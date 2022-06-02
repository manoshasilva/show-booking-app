package jpmc.book.workflow.booking;

import jpmc.book.context.Context;
import jpmc.book.display.Display;
import jpmc.book.exception.BookAShowException;
import jpmc.book.identity.Role;
import jpmc.book.model.Booking;
import jpmc.book.model.Show;
import jpmc.book.service.ServiceFactory;
import jpmc.book.validate.BookingValidator;
import jpmc.book.validate.PhoneValidator;
import jpmc.book.validate.SeatValidator;
import jpmc.book.workflow.BaseWorkflow;

import java.util.List;

public class BookingShowWorkflow extends BaseWorkflow {

    @Override
    public void executeAction(Context context) {
        ServiceFactory.getBookingService().bookAShow(context.getShow(),
                context.getBooking().bookingUserName(ServiceFactory.getLoginService()
                        .getLoggedInUser().getUserName()));
    }

    @Override
    protected void validate(Context context) throws BookAShowException {
        String showNumber = context.getShow().getShowNumber();
        Show show = ServiceFactory.getShowService().getShow(showNumber);
        SeatValidator.validate(show, context.getBooking());

        List<Booking> existingBookingList = ServiceFactory.getBookingService().getBookings(show);
        PhoneValidator.validate(existingBookingList, context.getBooking().getPhoneNumber());

        BookingValidator.validate(existingBookingList, context.getBooking());
    }

    @Override
    protected Role getAuthorizedRole() {
        return Role.MANAGE_BOOKING;
    }

    @Override
    protected void notifyUser(Context context) {
        Display.ticket(context.getBooking().getTicketId());
    }

}
