package jpmc.book.workflow.login;

import jpmc.book.context.Context;
import jpmc.book.display.Display;
import jpmc.book.exception.BookAShowException;
import jpmc.book.model.User;
import jpmc.book.service.ServiceFactory;
import jpmc.book.workflow.BaseWorkflow;

public class LogoffWorkflow extends BaseWorkflow {

    @Override
    public void executeAction(Context context) throws BookAShowException {
        ServiceFactory.getLoginService().logoff();
    }

    @Override
    protected void validate(Context context) throws BookAShowException {
        User loggedInUser = ServiceFactory.getLoginService().getLoggedInUser();
        if(loggedInUser == null) {
            throw new BookAShowException("User not Logged In");
        }
    }

    @Override
    protected void notifyUser(Context context) {
        Display.message("User Logged Off Successfully");
    }

}
