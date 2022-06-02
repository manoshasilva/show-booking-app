package jpmc.book.workflow.user;

import jpmc.book.context.Context;
import jpmc.book.display.Display;
import jpmc.book.service.ServiceFactory;
import jpmc.book.workflow.BaseWorkflow;

public class AddUserWorkflow extends BaseWorkflow {

    @Override
    public void executeAction(Context context) {
        ServiceFactory.getUserService().addUser(context.getUser());
    }

    @Override
    protected void notifyUser(Context context) {
        Display.message("User Created Successfully");
    }

}
