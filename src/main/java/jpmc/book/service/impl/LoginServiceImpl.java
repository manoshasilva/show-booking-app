package jpmc.book.service.impl;

import jpmc.book.dao.LoginDao;
import jpmc.book.model.User;
import jpmc.book.service.api.LoginService;

public class LoginServiceImpl implements LoginService {

    private LoginDao loginDao;

    public LoginServiceImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }

    @Override
    public boolean login(String username) {
        return loginDao.login(username);
    }

    @Override
    public boolean logoff() {
        return loginDao.logoff();
    }

    @Override
    public User getLoggedInUser() {
        return loginDao.getLoggedInUser();
    }

}
