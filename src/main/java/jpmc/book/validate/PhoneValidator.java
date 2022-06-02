package jpmc.book.validate;

import jpmc.book.exception.BookAShowException;
import jpmc.book.model.Booking;

import java.util.List;

public class PhoneValidator {

    public static void validate(List<Booking> bookings, String phoneNo) throws BookAShowException {
        if(bookings != null && bookings.size() > 0) {
            Booking bookingWithSamePhoneNo = bookings.stream()
                    .filter(booking -> booking.getPhoneNumber().equals(phoneNo))
                    .findAny().orElse(null);
            if(bookingWithSamePhoneNo != null) {
                throw new BookAShowException("Booking Already Exists With Phone No " + phoneNo);
            }
        }
    }

}
