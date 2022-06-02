package jpmc.book.dao.impl;

import jpmc.book.dao.ShowDao;
import jpmc.book.model.Show;
import jpmc.book.persistense.DataStore;

import java.util.List;

public class ShowDaoImpl implements ShowDao {

    @Override
    public void setup(Show show) {
        DataStore.getInstance().setUpShow(show);
    }

    @Override
    public Show getShow(String showNumber) {
        return DataStore.getInstance().getShow(showNumber);
    }

    @Override
    public List<String> getAvailableSeats(String showNumber) {
        return DataStore.getInstance().getAvailableSeats(showNumber);
    }

}
