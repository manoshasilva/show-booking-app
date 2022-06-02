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
public class ViewShowWorkflowTest {

    /**
     * Add Admin User -> Login -> Setup Show -> Logoff
     * Add Buyer User -> Login -> Book A Ticket -> Logoff
     * Login Admin User -> View Show -> Logoff
     */
    @Test
    public void viewShowSuccessTest() {
        try {
            Workflow addUserWorkflow = WorkflowLocator.getWorkflow(CommandType.ADD_USER);
            Context addUserContext = new Context().user(new User().userName("view_admin_1")
                    .userType(UserType.ADMIN));
            addUserWorkflow.execute(addUserContext);

            Workflow loginWorkflow = WorkflowLocator.getWorkflow(CommandType.LOGIN);
            Context loginContext = new Context().user(new User().userName("view_admin_1"));
            loginWorkflow.execute(loginContext);

            Context setupContext = new Context().show(new Show().showNumber("ViewShow1").noOfSeatsPerRow(4).noOfRows(4)
                    .cancellationWindowInMinutes(2));
            WorkflowLocator.getWorkflow(CommandType.SETUP_SHOW).execute(setupContext);

            WorkflowLocator.getWorkflow(CommandType.LOGOFF).execute(null);

            addUserWorkflow.execute(new Context().user(new User().userName("view_buyer1")
                    .userType(UserType.BUYER)));

            loginWorkflow.execute(new Context().user(new User().userName("view_buyer1")));

            Booking booking = new Booking().phoneNumber("1111").showNumber("ViewShow1");
            String[] seats = new String[]{"A1", "A2"};
            booking.addSeats(seats);
            WorkflowLocator.getWorkflow(CommandType.BOOK)
                    .execute(new Context().booking(booking).show(new Show().showNumber("ViewShow1")));

            WorkflowLocator.getWorkflow(CommandType.LOGOFF).execute(null);

            loginWorkflow.execute(loginContext);

            Context viewContext = new Context().show(new Show().showNumber("ViewShow1"));
            WorkflowLocator.getWorkflow(CommandType.VIEW_SHOW).execute(viewContext);

            WorkflowLocator.getWorkflow(CommandType.LOGOFF).execute(null);
        } catch(BookAShowException ex) {
            Assertions.fail("View Show Failed.");
        }
    }

}
