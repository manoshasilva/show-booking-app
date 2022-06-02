package jpmc.book.workflow.user;

import jpmc.book.context.Context;
import jpmc.book.display.Display;
import jpmc.book.exception.BookAShowException;
import jpmc.book.model.User;
import jpmc.book.service.ServiceFactory;
import jpmc.book.workflow.BaseWorkflow;

public class AddUserWorkflow extends BaseWorkflow {

    @Override
    public void executeAction(Context context) {
        ServiceFactory.getUserService().addUser(context.getUser());
    }

    @Override
    protected void validate(Context context) throws BookAShowException {
        if(context.getUser().getUserType() == null) {
            throw new BookAShowException("Invalid User Type");
        }

        User userFromDS = ServiceFactory.getUserService().getAllUsers().stream()
                .filter(user -> user.getUserName().equals(context.getUser().getUserName()))
                .findAny().orElse(null);
        if(userFromDS != null) {
            throw new BookAShowException("Username not Available");
        }
    }

    @Override
    protected void notifyUser(Context context) {
        Display.message("User Created Successfully");
    }

}
