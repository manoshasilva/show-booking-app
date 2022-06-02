package jpmc.book.workflow.login;

import jpmc.book.context.Context;
import jpmc.book.display.Display;
import jpmc.book.exception.BookAShowException;
import jpmc.book.model.User;
import jpmc.book.service.ServiceFactory;
import jpmc.book.workflow.BaseWorkflow;

public class LoginWorkflow extends BaseWorkflow {

    @Override
    public void executeAction(Context context) {
        ServiceFactory.getLoginService().login(context.getUser().getUserName());
    }

    @Override
    protected void validate(Context context) throws BookAShowException {
        User userFromDS = ServiceFactory.getUserService().getAllUsers().stream()
                .filter(user -> user.getUserName().equals(context.getUser().getUserName()))
                .findAny().orElse(null);
        if(userFromDS == null) {
            throw new BookAShowException("User Does Not Exist");
        }

        User loggedInUser = ServiceFactory.getLoginService().getLoggedInUser();
        if(loggedInUser != null) {
            throw new BookAShowException("User Already Logged In. Logoff the User Before Login.");
        }
    }

    @Override
    protected void notifyUser(Context context) {
        Display.message("User Logged In Successfully");
    }

}
