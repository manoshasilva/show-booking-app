package jpmc.book.workflow.user;

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
public class AddUserWorkflowTest {

    @Test
    public void addUserSuccessTest() {
        try {
            Context context = new Context().user(new User().userName("add_user_admin_1").userType(UserType.ADMIN));
            WorkflowLocator.getWorkflow(CommandType.ADD_USER).execute(context);
        } catch(BookAShowException ex) {
            Assertions.fail("AddUser Failed");
        }
    }

    @Test
    public void addUserNoUserTypeTest() {
        Context context = new Context().user(new User().userName("add_user_admin_2"));
            Assertions.assertThrows(BookAShowException.class,
                    () -> WorkflowLocator.getWorkflow(CommandType.ADD_USER).execute(context));
    }

    @Test
    public void addUserWithExistingUsernameTest() throws BookAShowException {
        Context context = new Context().user(new User().userName("add_user_admin_3").userType(UserType.ADMIN));
        WorkflowLocator.getWorkflow(CommandType.ADD_USER).execute(context);

        Assertions.assertThrows(BookAShowException.class,
                () -> WorkflowLocator.getWorkflow(CommandType.ADD_USER).execute(context));
    }

}
