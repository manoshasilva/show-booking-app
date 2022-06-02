package jpmc.book.validate;

import jpmc.book.exception.BookAShowException;
import jpmc.book.model.Show;

public class ShowValidator {

    private static final int MAX_NO_OF_ROWS = 26;
    private static final int MAX_SEATS_PER_ROW = 10;
    private static final int MIN_NO_OF_ROWS = 1;
    private static final int MIN_SEATS_PER_ROW = 1;

    public static void validate(Show show) throws BookAShowException {
        if(show.getNoOfRows() > MAX_NO_OF_ROWS || show.getNoOfRows() < MIN_NO_OF_ROWS) {
            throw new BookAShowException("Max No Of Rows Allowed is 26");
        }
        if(show.getNoOfSeatsPerRow() > MAX_SEATS_PER_ROW || show.getNoOfSeatsPerRow() < MIN_SEATS_PER_ROW) {
            throw new BookAShowException("Max No Of Seat Per Row Allowed is 10");
        }
    }

}
