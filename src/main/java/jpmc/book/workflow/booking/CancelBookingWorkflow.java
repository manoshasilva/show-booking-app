package jpmc.book.workflow.booking;

import jpmc.book.context.Context;
import jpmc.book.display.Display;
import jpmc.book.exception.BookAShowException;
import jpmc.book.identity.Role;
import jpmc.book.model.Booking;
import jpmc.book.model.Show;
import jpmc.book.service.ServiceFactory;
import jpmc.book.validate.CancelBookingTimeWindowValidator;
import jpmc.book.workflow.BaseWorkflow;

public class CancelBookingWorkflow extends BaseWorkflow {

    @Override
    public void executeAction(Context context) throws BookAShowException {
        Booking booking = context.getBooking();
        ServiceFactory.getBookingService().cancelBooking(booking.getTicketId(), booking.getPhoneNumber());
    }

    @Override
    protected Role getAuthorizedRole() {
        return Role.MANAGE_BOOKING;
    }

    @Override
    protected void validate(Context context) throws BookAShowException {
        Booking booking = context.getBooking();
        Booking bookingFromDS = ServiceFactory.getBookingService().getBooking(booking.getTicketId(),
                booking.getPhoneNumber());
        if(bookingFromDS == null) {
            throw new BookAShowException("No Booking With Given Ticket No and Phone No");
        }
        Show show = ServiceFactory.getShowService().getShow(bookingFromDS.getShowNumber());
        CancelBookingTimeWindowValidator.validate(bookingFromDS, show);
    }

    @Override
    protected void notifyUser(Context context) {
        Display.message("Ticket Successfully Cancelled");
    }

}
