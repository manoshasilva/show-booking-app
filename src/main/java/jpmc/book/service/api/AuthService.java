package jpmc.book.service.api;

import jpmc.book.exception.BookAShowException;
import jpmc.book.identity.Role;

public interface AuthService {

    void authorize(Role authorizedRole) throws BookAShowException;

}
