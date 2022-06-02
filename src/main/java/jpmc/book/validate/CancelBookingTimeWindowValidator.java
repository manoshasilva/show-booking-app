package jpmc.book.validate;

import jpmc.book.exception.BookAShowException;
import jpmc.book.model.Booking;
import jpmc.book.model.Show;

public class CancelBookingTimeWindowValidator {

    public static void validate(Booking booking, Show show) throws BookAShowException {
        Integer cancelValidTime = show.getCancellationWindowInMinutes();
        long purchasedTime = booking.getPurchasedTimeInMillis();
        if(System.currentTimeMillis() > purchasedTime + cancelValidTime * 60 * 1000) {
            throw new BookAShowException("Cancellation Window of " + cancelValidTime + " Minutes Has Expired.");
        }
    }

}
