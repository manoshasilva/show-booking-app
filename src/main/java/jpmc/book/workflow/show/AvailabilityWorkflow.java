package jpmc.book.workflow.show;

import jpmc.book.context.Context;
import jpmc.book.display.Display;
import jpmc.book.exception.BookAShowException;
import jpmc.book.identity.Role;
import jpmc.book.model.Show;
import jpmc.book.service.ServiceFactory;
import jpmc.book.workflow.BaseWorkflow;

import java.util.List;

public class AvailabilityWorkflow extends BaseWorkflow {

    @Override
    public void executeAction(Context context) {
        List<String> availableSeats = ServiceFactory.getShowService().getAvailableSeats(context.getShow()
                .getShowNumber());
        context.availableSeats(availableSeats);
    }

    @Override
    protected Role getAuthorizedRole() {
        return Role.MANAGE_BOOKING;
    }

    @Override
    protected void notifyUser(Context context) {
        Display.availableSeats(context.getShow().getShowNumber(), context.getAvailableSeats());
    }

    @Override
    protected void validate(Context context) throws BookAShowException {
        Show show = ServiceFactory.getShowService().getShow(context.getShow().getShowNumber());
        if(show == null) {
            throw new BookAShowException("Show Does Not Exist");
        }
    }

}
