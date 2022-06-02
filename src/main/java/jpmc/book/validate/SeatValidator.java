package jpmc.book.validate;

import jpmc.book.exception.BookAShowException;
import jpmc.book.model.Booking;
import jpmc.book.model.Show;
import jpmc.book.rows.Rows;

import java.util.List;

public class SeatValidator {

    public static void validate(Show show, Booking booking) throws BookAShowException {
        Integer noOfRows = show.getNoOfRows();
        Integer noOfOfSeatsPerRow = show.getNoOfSeatsPerRow();
        List<String> bookingSeatIds = booking.getSeats();
        for(String bookingSeatId: bookingSeatIds) {
            String row = String.valueOf(bookingSeatId.charAt(0));
            Rows rowEnum = Rows.valueOf(row);
            if(rowEnum.getRowId() > noOfRows) {
                throw new BookAShowException("You Have Entered Invalid Seat IDs");
            }

            try {
                Integer seatIdInRow = Integer.valueOf(bookingSeatId.substring(1));
                if (seatIdInRow > noOfOfSeatsPerRow || seatIdInRow == 0) {
                    throw new BookAShowException("You Have Entered Invalid Seat IDs");
                }
            } catch(NumberFormatException ex) {
                throw new BookAShowException("You Have Entered Invalid Seat IDs");
            }
        }

    }

}
