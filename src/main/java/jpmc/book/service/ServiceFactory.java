package jpmc.book.service;

import jpmc.book.dao.BookingDao;
import jpmc.book.dao.LoginDao;
import jpmc.book.dao.ShowDao;
import jpmc.book.dao.UserDao;
import jpmc.book.dao.impl.BookingDaoImpl;
import jpmc.book.dao.impl.LoginDaoImpl;
import jpmc.book.dao.impl.ShowDaoImpl;
import jpmc.book.dao.impl.UserDaoImpl;
import jpmc.book.service.api.*;
import jpmc.book.service.impl.*;

public class ServiceFactory {

    private static BookingService bookingService;
    private static ShowService showService;
    private static LoginService loginService;
    private static AuthService authService;
    private static UserService userService;

    public static BookingService getBookingService() {
        if(bookingService == null) {
            BookingDao bookingDao = new BookingDaoImpl();
            bookingService = new BookingServiceImpl(bookingDao);
        }
        return bookingService;
    }

    public static ShowService getShowService() {
        if(showService == null) {
            ShowDao showDao = new ShowDaoImpl();
            showService = new ShowServiceImpl(showDao);
        }
        return showService;
    }

    public static LoginService getLoginService() {
        if(loginService == null) {
            LoginDao loginDao = new LoginDaoImpl();
            loginService = new LoginServiceImpl(loginDao);
        }
        return loginService;
    }

    public static AuthService getAuthService() {
        if(authService == null) {
            authService = new AuthServiceImpl();
        }
        return authService;
    }

    public static UserService getUserService() {
        if(userService == null) {
            UserDao userDao = new UserDaoImpl();
            userService = new UserServiceImpl(userDao);
        }
        return userService;
    }

}
