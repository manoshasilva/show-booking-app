package jpmc.book.context;

import jpmc.book.model.Booking;
import jpmc.book.model.Show;
import jpmc.book.model.User;

import java.util.List;

public class Context {

    private User user;
    private Show show;
    private Booking booking;
    private List<String> availableSeats;
    private List<Booking> showBookings;

    public Context user(User user) {
        this.user = user;
        return this;
    }

    public Context show(Show show) {
        this.show = show;
        return this;
    }

    public Context booking(Booking booking) {
        this.booking = booking;
        return this;
    }

    public Context availableSeats(List<String> seats) {
        this.availableSeats = seats;
        return this;
    }

    public Context showBookings(List<Booking> showBookings) {
        this.showBookings = showBookings;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Show getShow() {
        return show;
    }

    public Booking getBooking() {
        return booking;
    }

    public List<String> getAvailableSeats() {
        return availableSeats;
    }

    public List<Booking> getShowBookings() {
        return showBookings;
    }

}
