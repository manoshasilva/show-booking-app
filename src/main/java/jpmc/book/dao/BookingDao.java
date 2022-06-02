package jpmc.book.dao;

import jpmc.book.exception.BookAShowException;
import jpmc.book.model.Booking;
import jpmc.book.model.Show;

import java.util.List;

public interface BookingDao {

    void bookAShow(Show show, Booking booking);

    void cancelBooking(String ticketNo, String phoneNo) throws BookAShowException;

    List<Booking> getBookings(Show show);

    Booking getBooking(String ticketNo, String phoneNo);

}
