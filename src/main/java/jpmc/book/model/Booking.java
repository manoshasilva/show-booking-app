package jpmc.book.model;

import java.util.*;

public class Booking {

    private List<String> seatIds = new ArrayList<>();

    private String showNumber;

    private String bookingUserName;

    private String phoneNumber;

    private String ticketId;

    private long purchasedTimeInMillis;

    public Booking() {
        ticketId = UUID.randomUUID().toString();
    }

    public List<String> getSeats() {
        return new ArrayList<>(seatIds);
    }

    public void addSeat(String seatId) {
        seatIds.add(seatId);
    }

    public void addSeats(String[] seats) {
        seatIds.addAll(Arrays.asList(seats));
    }

    private String getBookingUserName() {
        return bookingUserName;
    }

    public Booking bookingUserName(String bookingUserName) {
        this.bookingUserName = bookingUserName;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Booking phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getShowNumber() {
        return showNumber;
    }

    public Booking showNumber(String showNumber) {
        this.showNumber = showNumber;
        return this;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Booking ticketId(String ticketId) {
        this.ticketId = ticketId;
        return this;
    }

    public long getPurchasedTimeInMillis() {
        return purchasedTimeInMillis;
    }

    public Booking purchasedTimeInMillis(long purchasedTimeInMillis) {
        this.purchasedTimeInMillis = purchasedTimeInMillis;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return Objects.equals(seatIds, booking.seatIds) &&
                Objects.equals(getShowNumber(), booking.getShowNumber()) &&
                Objects.equals(getBookingUserName(), booking.getBookingUserName()) &&
                Objects.equals(getPhoneNumber(), booking.getPhoneNumber()) &&
                Objects.equals(getTicketId(), booking.getTicketId());
    }
}
