package jpmc.book.utils;

import jpmc.book.model.Show;
import jpmc.book.rows.Rows;

import java.util.ArrayList;
import java.util.List;

public class SeatsUtil {

    public static List<String> getAllSeats(Show show) {
        List<String> seats = new ArrayList<>();
        for(int rowNum = 1; rowNum <= show.getNoOfRows(); rowNum++) {
            for(int rowSeatNo = 1; rowSeatNo <= show.getNoOfSeatsPerRow(); rowSeatNo++) {
                seats.add(Rows.getRowById(rowNum) + rowSeatNo);
            }
        }
        return seats;
    }

}
