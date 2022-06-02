package jpmc.book.workflow.show;

import jpmc.book.context.Context;
import jpmc.book.display.Display;
import jpmc.book.exception.BookAShowException;
import jpmc.book.identity.Role;
import jpmc.book.service.ServiceFactory;
import jpmc.book.validate.ShowValidator;
import jpmc.book.workflow.BaseWorkflow;

public class SetUpShowWorkflow extends BaseWorkflow {

    @Override
    public void executeAction(Context context) {
        ServiceFactory.getShowService().setUpShow(context.getShow());
    }

    @Override
    protected Role getAuthorizedRole() {
        return Role.MANAGE_SHOW;
    }

    @Override
    protected void validate(Context context) throws BookAShowException {
        ShowValidator.validate(context.getShow());
    }

    @Override
    protected void notifyUser(Context context) {
        Display.message("Show Setup Successful");
    }

}
