package jpmc.book.workflow.booking;

import jpmc.book.context.Context;
import jpmc.book.exception.BookAShowException;
import jpmc.book.interpreter.command.enums.CommandType;
import jpmc.book.model.Booking;
import jpmc.book.model.Show;
import jpmc.book.model.User;
import jpmc.book.model.UserType;
import jpmc.book.workflow.Workflow;
import jpmc.book.workflow.WorkflowLocator;
import net.jcip.annotations.NotThreadSafe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@NotThreadSafe
public class BookingShowWorkflowTest {

    /**
     * Add Admin User -> Login -> Setup Show -> Logoff
     * Add Buyer User -> Login -> Book A Ticket -> Logoff
     */
    @Test
    public void bookingShowSuccessTest() {
        try {
            Workflow addUserWorkflow = WorkflowLocator.getWorkflow(CommandType.ADD_USER);
            Workflow loginWorkflow = WorkflowLocator.getWorkflow(CommandType.LOGIN);

            setupShow(addUserWorkflow, loginWorkflow, "booking_admin_1", "BookingShow1");

            addUserWorkflow.execute(new Context().user(new User().userName("booking_buyer1")
                    .userType(UserType.BUYER)));

            loginWorkflow.execute(new Context().user(new User().userName("booking_buyer1")));

            Booking booking = new Booking().phoneNumber("1111").showNumber("BookingShow1");
            String[] seats = new String[]{"A1", "A2"};
            booking.addSeats(seats);
            WorkflowLocator.getWorkflow(CommandType.BOOK)
                    .execute(new Context().booking(booking).show(new Show().showNumber("BookingShow1")));

            WorkflowLocator.getWorkflow(CommandType.LOGOFF).execute(null);
        } catch(BookAShowException ex) {
            Assertions.fail("View Show Failed.");
        }
    }

    @Test
    public void bookingShowDuplicatePhoneNoTest() throws BookAShowException {
        Workflow addUserWorkflow = WorkflowLocator.getWorkflow(CommandType.ADD_USER);
        Workflow loginWorkflow = WorkflowLocator.getWorkflow(CommandType.LOGIN);

        setupShow(addUserWorkflow, loginWorkflow, "booking_admin_2", "BookingShow2");

        addUserWorkflow.execute(new Context().user(new User().userName("booking_buyer2")
                .userType(UserType.BUYER)));

        loginWorkflow.execute(new Context().user(new User().userName("booking_buyer2")));

        Booking booking = new Booking().phoneNumber("1111").showNumber("BookingShow2");
        String[] seats = new String[]{"A1", "A2"};
        booking.addSeats(seats);
        WorkflowLocator.getWorkflow(CommandType.BOOK)
                .execute(new Context().booking(booking).show(new Show().showNumber("BookingShow2")));

        Booking booking2 = new Booking().phoneNumber("1111").showNumber("BookingShow2");
        String[] seats2 = new String[]{"B1", "B2"};
        booking.addSeats(seats2);
        Assertions.assertThrows(BookAShowException.class,
                () -> WorkflowLocator.getWorkflow(CommandType.BOOK)
                        .execute(new Context().booking(booking2).show(new Show().showNumber("BookingShow2"))));

        WorkflowLocator.getWorkflow(CommandType.LOGOFF).execute(null);
    }

    private void setupShow(Workflow addUserWorkflow, Workflow loginWorkflow, String userName, String showNumber) throws BookAShowException {
        Context addUserContext = new Context().user(new User().userName(userName)
                .userType(UserType.ADMIN));
        addUserWorkflow.execute(addUserContext);

        Context loginContext = new Context().user(new User().userName(userName));
        loginWorkflow.execute(loginContext);

        Context setupContext = new Context().show(new Show().showNumber(showNumber).noOfSeatsPerRow(4).noOfRows(4)
                .cancellationWindowInMinutes(2));
        WorkflowLocator.getWorkflow(CommandType.SETUP_SHOW).execute(setupContext);

        WorkflowLocator.getWorkflow(CommandType.LOGOFF).execute(null);
    }

}
