package jpmc.book.validate;

import jpmc.book.exception.BookAShowException;
import jpmc.book.model.Booking;

import java.util.List;

public class BookingValidator {

    public static void validate(List<Booking> existingBookings, Booking newBooking) throws BookAShowException {
        if(existingBookings != null) {
            String alreadyBookedSeatIds = existingBookings.stream().flatMap(alreadyBooked -> alreadyBooked.getSeats().stream())
                    .filter(seatId -> newBooking.getSeats().contains(seatId)).findAny().orElse(null);
            if(alreadyBookedSeatIds != null) {
                throw new BookAShowException("Some Seats Entered Are Already Booked");
            }
        }
    }

}
