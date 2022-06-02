package jpmc.book.dao;

import jpmc.book.model.Show;

import java.util.List;

public interface ShowDao {

    void setup(Show show);

    Show getShow(String showNumber);

    List<String> getAvailableSeats(String showNumber);

    List<Show> getAllShows();
}
