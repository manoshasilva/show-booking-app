package jpmc.book.dao.impl;

import jpmc.book.dao.BookingDao;
import jpmc.book.model.Booking;
import jpmc.book.model.Show;
import jpmc.book.persistense.DataStore;

import java.util.List;

public class BookingDaoImpl implements BookingDao {

    @Override
    public void bookAShow(Show show, Booking booking) {
        DataStore.getInstance().bookAShow(show, booking);
    }

    @Override
    public void cancelBooking(String ticketNo, String phoneNo) {
        DataStore.getInstance().cancelBooking(ticketNo, phoneNo);
    }

    @Override
    public List<Booking> getBookings(Show show) {
        return DataStore.getInstance().getBookings(show);
    }

    @Override
    public Booking getBooking(String ticketNo, String phoneNo) {
        return DataStore.getInstance().getBooking(ticketNo, phoneNo);
    }

}
