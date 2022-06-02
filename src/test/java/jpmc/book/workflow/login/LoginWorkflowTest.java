package jpmc.book.workflow.login;

import jpmc.book.context.Context;
import jpmc.book.exception.BookAShowException;
import jpmc.book.interpreter.command.enums.CommandType;
import jpmc.book.model.User;
import jpmc.book.model.UserType;
import jpmc.book.workflow.WorkflowLocator;
import net.jcip.annotations.NotThreadSafe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@NotThreadSafe
public class LoginWorkflowTest {

    @Test
    public void loginTest() {
        try {
            Context addUserContext = new Context().user(new User().userName("login_admin_1").userType(UserType.ADMIN));
            WorkflowLocator.getWorkflow(CommandType.ADD_USER).execute(addUserContext);

            Context loginContext = new Context().user(new User().userName("login_admin_1"));
            WorkflowLocator.getWorkflow(CommandType.LOGIN).execute(loginContext);
        } catch(BookAShowException ex) {
            Assertions.fail("Login Failed.");
        }
    }

    @Test
    public void loginWithInvalidUsernameTest() {
        Context loginContext = new Context().user(new User().userName("login_admin_2"));
        Assertions.assertThrows(BookAShowException.class,
                () -> WorkflowLocator.getWorkflow(CommandType.LOGIN).execute(loginContext));
    }

}
