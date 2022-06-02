package jpmc.book.service.impl;

import jpmc.book.dao.BookingDao;
import jpmc.book.exception.BookAShowException;
import jpmc.book.model.Booking;
import jpmc.book.model.Show;
import jpmc.book.service.api.BookingService;

import java.util.List;

public class BookingServiceImpl implements BookingService {

    private BookingDao bookingDao;

    public BookingServiceImpl(BookingDao bookingDao) {
        this.bookingDao = bookingDao;
    }

    @Override
    public void bookAShow(Show show, Booking booking) {
        bookingDao.bookAShow(show, booking);
    }

    @Override
    public void cancelBooking(String ticketNo, String phoneNo) throws BookAShowException {
        bookingDao.cancelBooking(ticketNo, phoneNo);
    }

    @Override
    public List<Booking> getBookings(Show show) {
        return bookingDao.getBookings(show);
    }

    @Override
    public Booking getBooking(String ticketNo, String phoneNo) {
        return bookingDao.getBooking(ticketNo, phoneNo);
    }

}
