package jpmc.book.display;

import jpmc.book.exception.BookAShowException;
import jpmc.book.model.Booking;
import jpmc.book.model.Show;

import java.util.List;

public class Display {

    public static void message(String message) {
        System.out.println(message);
    }

    public static void show(Show show) {
        System.out.println("Show Number: " + show.getShowNumber());
    }

    public static void bookings(List<Booking> bookings) {
        if(bookings != null) {
            for(Booking booking: bookings) {
                StringBuilder message = new StringBuilder();
                message.append("Ticket# : ").append(booking.getTicketId()).append(" , ");
                message.append("Buyer Phone# : ").append(booking.getPhoneNumber()).append(" , ");
                message.append("Seat Numbers : ").append(String.join(" ", booking.getSeats()));
                message(message.toString());
            }
        }
    }

    public static void exception(BookAShowException ex) {
        message(ex.getErrorMessage());
    }

    public static void ticket(String ticketId) {
        message("Booking is Successfully Completed.");
        message("Your Ticket ID : " + ticketId);
    }

    public static void availableSeats(String showNumber, List<String> availableSeats) {
        message("Available Seats For the Show '" + showNumber + "' :");
        message(String.join(" ", availableSeats));
    }

    public static void help() {
        message("Add a new user and Login before calling Admin or Buyer Commands.");
        message(" ");
        message("AddUser <username> <admin|buyer>");
        message("Login <username>");
        message("Logoff");
        message(" ");
        message("ADMIN Commands");
        message("Setup <Show Number> <Number of Rows> <Number of seats per row> <Cancellation window in minutes>");
        message("View <Show Number>");
        message(" ");
        message("BUYER Commands");
        message("Availability <Show Number>");
        message("Book <Show Number> <Phone#> <Comma separated list of seats>");
        message("Cancel <Ticket#> <Phone#>");
    }

}
