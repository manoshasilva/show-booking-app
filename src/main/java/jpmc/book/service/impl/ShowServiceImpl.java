package jpmc.book.service.impl;

import jpmc.book.dao.ShowDao;
import jpmc.book.model.Show;
import jpmc.book.service.api.ShowService;

import java.util.List;

public class ShowServiceImpl implements ShowService {

    private ShowDao showDao;

    public ShowServiceImpl(ShowDao showDao) {
        this.showDao = showDao;
    }

    @Override
    public void setUpShow(Show show) {
        showDao.setup(show);
    }

    @Override
    public Show getShow(String showNumber) {
        return showDao.getShow(showNumber);
    }

    @Override
    public List<String> getAvailableSeats(String showNumber) {
        return showDao.getAvailableSeats(showNumber);
    }

    @Override
    public List<Show> getAllShows() {
        return showDao.getAllShows();
    }

}
