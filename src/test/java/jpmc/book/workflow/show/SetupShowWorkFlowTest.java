package jpmc.book.workflow.show;

import jpmc.book.context.Context;
import jpmc.book.exception.BookAShowException;
import jpmc.book.interpreter.command.enums.CommandType;
import jpmc.book.model.Show;
import jpmc.book.model.User;
import jpmc.book.model.UserType;
import jpmc.book.workflow.WorkflowLocator;
import net.jcip.annotations.NotThreadSafe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@NotThreadSafe
public class SetupShowWorkFlowTest {

    @Test
    public void setupShowSuccessTest() {
        try {
            Context addUserContext = new Context().user(new User().userName("setup_admin_1").userType(UserType.ADMIN));
            WorkflowLocator.getWorkflow(CommandType.ADD_USER).execute(addUserContext);

            Context loginContext = new Context().user(new User().userName("setup_admin_1"));
            WorkflowLocator.getWorkflow(CommandType.LOGIN).execute(loginContext);

            Context setupContext = new Context().show(new Show().showNumber("Show1").noOfSeatsPerRow(4).noOfRows(4)
                    .cancellationWindowInMinutes(2));
            WorkflowLocator.getWorkflow(CommandType.SETUP_SHOW).execute(setupContext);

            WorkflowLocator.getWorkflow(CommandType.LOGOFF).execute(null);
        } catch(BookAShowException ex) {
            Assertions.fail("Setup Show Failed.");
        }
    }

    @Test
    public void setupShowInvalidRowsTest() throws BookAShowException {
        Context addUserContext = new Context().user(new User().userName("setup_admin_2").userType(UserType.ADMIN));
        WorkflowLocator.getWorkflow(CommandType.ADD_USER).execute(addUserContext);

        Context loginContext = new Context().user(new User().userName("setup_admin_2"));
        WorkflowLocator.getWorkflow(CommandType.LOGIN).execute(loginContext);

        Context setupContext = new Context().show(new Show().showNumber("Show2").noOfSeatsPerRow(4).noOfRows(27)
                .cancellationWindowInMinutes(2));
        Assertions.assertThrows(BookAShowException.class,
                () -> WorkflowLocator.getWorkflow(CommandType.SETUP_SHOW).execute(setupContext));

        WorkflowLocator.getWorkflow(CommandType.LOGOFF).execute(null);
    }

    @Test
    public void setupShowInvalidSeatsInRowsTest() throws BookAShowException {
        Context addUserContext = new Context().user(new User().userName("setup_admin_3").userType(UserType.ADMIN));
        WorkflowLocator.getWorkflow(CommandType.ADD_USER).execute(addUserContext);

        Context loginContext = new Context().user(new User().userName("setup_admin_3"));
        WorkflowLocator.getWorkflow(CommandType.LOGIN).execute(loginContext);

        Context setupContext = new Context().show(new Show().showNumber("Show3").noOfSeatsPerRow(11).noOfRows(26)
                .cancellationWindowInMinutes(2));
        Assertions.assertThrows(BookAShowException.class,
                () -> WorkflowLocator.getWorkflow(CommandType.SETUP_SHOW).execute(setupContext));

        WorkflowLocator.getWorkflow(CommandType.LOGOFF).execute(null);
    }

    @Test
    public void setupShowWithDuplicateNumberTest() throws BookAShowException {
        Context addUserContext = new Context().user(new User().userName("setup_admin_4").userType(UserType.ADMIN));
        WorkflowLocator.getWorkflow(CommandType.ADD_USER).execute(addUserContext);

        Context loginContext = new Context().user(new User().userName("setup_admin_4"));
        WorkflowLocator.getWorkflow(CommandType.LOGIN).execute(loginContext);

        Context setupContext = new Context().show(new Show().showNumber("Show4").noOfSeatsPerRow(4).noOfRows(4)
                .cancellationWindowInMinutes(2));
        WorkflowLocator.getWorkflow(CommandType.SETUP_SHOW).execute(setupContext);

        Assertions.assertThrows(BookAShowException.class,
                () -> WorkflowLocator.getWorkflow(CommandType.SETUP_SHOW).execute(setupContext));

        WorkflowLocator.getWorkflow(CommandType.LOGOFF).execute(null);
    }

    @Test
    public void setupShowWithUnauthorizedUserTypeTest() throws BookAShowException {
        Context addUserContext = new Context().user(new User().userName("setup_admin_5").userType(UserType.BUYER));
        WorkflowLocator.getWorkflow(CommandType.ADD_USER).execute(addUserContext);

        Context loginContext = new Context().user(new User().userName("setup_admin_5"));
        WorkflowLocator.getWorkflow(CommandType.LOGIN).execute(loginContext);

        Context setupContext = new Context().show(new Show().showNumber("Show5").noOfSeatsPerRow(4).noOfRows(4)
                .cancellationWindowInMinutes(2));
        Assertions.assertThrows(BookAShowException.class,
                () -> WorkflowLocator.getWorkflow(CommandType.SETUP_SHOW).execute(setupContext));

        WorkflowLocator.getWorkflow(CommandType.LOGOFF).execute(null);
    }

    @Test
    public void setupShowWithoutLoginTest() {
        Context setupContext = new Context().show(new Show().showNumber("Show6").noOfSeatsPerRow(4).noOfRows(4)
                .cancellationWindowInMinutes(2));
        Assertions.assertThrows(BookAShowException.class,
                () -> WorkflowLocator.getWorkflow(CommandType.SETUP_SHOW).execute(setupContext));
    }

}
