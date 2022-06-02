package jpmc.book.service.api;

import jpmc.book.model.Show;

import java.util.List;

public interface ShowService {

    void setUpShow(Show show);

    Show getShow(String showNumber);

    List<String> getAvailableSeats(String showNumber);

    List<Show> getAllShows();

}
