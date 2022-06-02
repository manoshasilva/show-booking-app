package jpmc.book.workflow.show;

import jpmc.book.context.Context;
import jpmc.book.display.Display;
import jpmc.book.exception.BookAShowException;
import jpmc.book.identity.Role;
import jpmc.book.model.Booking;
import jpmc.book.model.Show;
import jpmc.book.service.ServiceFactory;
import jpmc.book.workflow.BaseWorkflow;

import java.util.List;

public class ViewShowWorkflow extends BaseWorkflow {

    @Override
    public void executeAction(Context context) {
        Show show = ServiceFactory.getShowService().getShow(context.getShow().getShowNumber());
        List<Booking> bookings = ServiceFactory.getBookingService().getBookings(show);
        context.show(show).showBookings(bookings);
    }

    @Override
    protected Role getAuthorizedRole() {
        return Role.MANAGE_SHOW;
    }

    @Override
    protected void validate(Context context) throws BookAShowException {
        Show show = ServiceFactory.getShowService().getShow(context.getShow().getShowNumber());
        if(show == null) {
            throw new BookAShowException("Show Does Not Exist");
        }
    }

    @Override
    protected void notifyUser(Context context) {
        Display.show(context.getShow());
        Display.bookings(context.getShowBookings());
    }

}
