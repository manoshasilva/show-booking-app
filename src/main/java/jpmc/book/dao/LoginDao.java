package jpmc.book.dao;

import jpmc.book.model.User;

public interface LoginDao {

    boolean login(String username);

    boolean logoff();

    User getLoggedInUser();

}
