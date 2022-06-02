package jpmc.book.service.api;

import jpmc.book.exception.BookAShowException;
import jpmc.book.model.User;

public interface LoginService {

    boolean login(String username);

    boolean logoff() throws BookAShowException;

    User getLoggedInUser();

}
