package jpmc.book.dao.impl;

import jpmc.book.dao.UserDao;
import jpmc.book.model.User;
import jpmc.book.persistense.DataStore;

import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public void addUser(User user) {
        DataStore.getInstance().saveUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return DataStore.getInstance().getAllUsers();
    }

}
