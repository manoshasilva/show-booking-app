package jpmc.book.workflow.show;

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
public class AvailabilityWorkflowTest {

    @Test
    public void availabilitySuccessTest() {
        try {
            Workflow addUserWorkflow = WorkflowLocator.getWorkflow(CommandType.ADD_USER);
            Workflow loginWorkflow = WorkflowLocator.getWorkflow(CommandType.LOGIN);

            setupShow(addUserWorkflow, loginWorkflow, "avail_admin_1", "AvailShow1");

            addUserWorkflow.execute(new Context().user(new User().userName("avail_buyer1")
                    .userType(UserType.BUYER)));

            loginWorkflow.execute(new Context().user(new User().userName("avail_buyer1")));

            Booking booking = new Booking().phoneNumber("1111").showNumber("AvailShow1");
            String[] seats = new String[]{"A1", "A2"};
            booking.addSeats(seats);
            WorkflowLocator.getWorkflow(CommandType.BOOK)
                    .execute(new Context().booking(booking).show(new Show().showNumber("AvailShow1")));

            WorkflowLocator.getWorkflow(CommandType.AVAILABILITY)
                    .execute(new Context().show(new Show().showNumber("AvailShow1")));

            WorkflowLocator.getWorkflow(CommandType.LOGOFF).execute(null);
        } catch(BookAShowException ex) {
            Assertions.fail("View Show Failed.");
        }
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
