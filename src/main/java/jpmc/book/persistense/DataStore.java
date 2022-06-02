package jpmc.book.persistense;

import jpmc.book.model.Booking;
import jpmc.book.model.Show;
import jpmc.book.model.User;
import jpmc.book.utils.SeatsUtil;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataStore {

    private List<User> users = new ArrayList<>();
    private List<Show> shows = new ArrayList<>();
    private String loggedInUser;
    private Map<Show, List<Booking>> bookingsMap = new HashMap<>();

    private DataStore() {

    }

    private static class MemoryDBHolder {
        private static DataStore dataStore = new DataStore();
    }

    public static DataStore getInstance() {
        return MemoryDBHolder.dataStore;
    }

    public void saveUser(User user) {
        users.add(user);
    }

    public void setUpShow(Show show) {
        shows.add(show);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

    public Show getShow(String showNumber) {
        return shows.stream().filter(show -> show.getShowNumber().equalsIgnoreCase(showNumber))
                .findAny().orElse(null);
    }

    public boolean login(String username) {
        User user = users.stream().filter(tmpUser -> tmpUser.getUserName().equals(username))
                .findAny().orElse(null);
        if(user != null) {
            loggedInUser = username;
            return true;
        }
        return false;
    }

    public boolean logoff() {
        if(loggedInUser != null) {
            loggedInUser = null;
        }
        return true;
    }

    public User getLoggedInUser() {
        return users.stream().filter(user -> user.getUserName().equals(loggedInUser)).findAny().orElse(null);
    }

    public void bookAShow(Show show, Booking booking) {
        Show showFromDataStore = getShow(show.getShowNumber());
        List<Booking> bookingList = bookingsMap.get(getShow(show.getShowNumber()));
        if(bookingList == null || bookingList.size() == 0) {
            bookingList = new ArrayList<>();
        }

        booking.purchasedTimeInMillis(System.currentTimeMillis());
        bookingList.add(booking);
        bookingsMap.put(showFromDataStore, bookingList);

    }

    public List<String> getAvailableSeats(String showNumber) {
        Show show = getShow(showNumber);
        List<String> allSeatIds = SeatsUtil.getAllSeats(show);
        List<Booking> bookingList = bookingsMap.get(show);
        if(bookingList != null && bookingList.size() > 0) {
            List<String> bookedSeatsList = bookingsMap.get(show).stream()
                    .flatMap(booking -> booking == null || booking.getSeats() == null ?
                            Stream.empty() : booking.getSeats().stream())
                    .collect(Collectors.toList());
            allSeatIds.removeAll(bookedSeatsList);
        }
        return allSeatIds;
    }

    public void cancelBooking(String ticketNo, String phoneNo) {
        Booking bookingToCancel = bookingsMap.values().stream().flatMap(Collection::stream)
                .filter(booking -> booking.getTicketId().equals(ticketNo) && booking.getPhoneNumber().equals(phoneNo))
                .findAny().orElse(null);
        if(bookingToCancel != null) {
            Show showWithBookingToCancel = getShow(bookingToCancel.getShowNumber());
            List<Booking> bookingList = bookingsMap.get(showWithBookingToCancel);
            bookingList.remove(bookingToCancel);
        }
    }

    public Booking getBooking(String ticketNo, String phoneNo) {
        return bookingsMap.values().stream().flatMap(Collection::stream)
                .filter(booking -> booking.getTicketId().equals(ticketNo) && booking.getPhoneNumber().equals(phoneNo))
                .findAny().orElse(null);
    }

    public List<Booking> getBookings(Show show) {
        return bookingsMap.get(show);
    }

    public List<Show> getAllShows() {
        return shows;
    }

}
