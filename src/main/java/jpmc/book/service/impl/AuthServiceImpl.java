package jpmc.book.service.impl;

import jpmc.book.dao.LoginDao;
import jpmc.book.dao.impl.LoginDaoImpl;
import jpmc.book.exception.BookAShowException;
import jpmc.book.identity.Role;
import jpmc.book.identity.UserRole;
import jpmc.book.model.User;
import jpmc.book.model.UserType;
import jpmc.book.service.api.AuthService;
import jpmc.book.service.api.LoginService;

import java.util.List;

public class AuthServiceImpl implements AuthService {

    private LoginService loginService;

    @Override
    public void authorize(Role authorizedRole) throws BookAShowException {
        if(authorizedRole != null) {
            User loggedInUser = getLoginService().getLoggedInUser();
            if(loggedInUser == null) {
                throw new BookAShowException("User Not Logged In");
            }

            UserType loggedInUserType = loggedInUser.getUserType();
            List<Role> loggedInUsersRoles = UserRole.getRoles(loggedInUserType);
            if(!loggedInUsersRoles.contains(authorizedRole)) {
                throw new BookAShowException("Not Authorized To This Function");
            }
        }
    }

    private LoginService getLoginService() {
        if(loginService == null) {
            LoginDao loginDao = new LoginDaoImpl();
            loginService = new LoginServiceImpl(loginDao);
        }
        return loginService;
    }

}
