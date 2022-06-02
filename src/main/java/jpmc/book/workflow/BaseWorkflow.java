package jpmc.book.workflow;

import jpmc.book.context.Context;
import jpmc.book.exception.BookAShowException;
import jpmc.book.identity.Role;
import jpmc.book.service.ServiceFactory;

public abstract class BaseWorkflow implements Workflow {

    public void execute(Context context) throws BookAShowException {
        authorize();
        validate(context);
        executeAction(context);
        notifyUser(context);
    }

    protected void executeAction(Context context) throws BookAShowException {

    }

    protected void notifyUser(Context context) {

    }

    private void authorize() throws BookAShowException {
        Role authorizedRole = getAuthorizedRole();
        ServiceFactory.getAuthService().authorize(authorizedRole);
    }

    protected Role getAuthorizedRole() {
        return null;
    }

    protected void validate(Context context) throws BookAShowException {

    }

}
