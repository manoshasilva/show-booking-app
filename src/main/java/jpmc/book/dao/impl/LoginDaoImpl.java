package jpmc.book.dao.impl;

import jpmc.book.dao.LoginDao;
import jpmc.book.exception.BookAShowException;
import jpmc.book.model.User;
import jpmc.book.persistense.DataStore;

public class LoginDaoImpl implements LoginDao {

    @Override
    public boolean login(String username) {
        return DataStore.getInstance().login(username);
    }

    @Override
    public boolean logoff() {
        return DataStore.getInstance().logoff();
    }

    @Override
    public User getLoggedInUser() {
        return DataStore.getInstance().getLoggedInUser();
    }
}
