package jpmc.book.dao;

import jpmc.book.model.User;

import java.util.List;

public interface UserDao {

    void addUser(User user);

    List<User> getAllUsers();

}
