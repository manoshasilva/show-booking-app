package jpmc.book.service.api;

import jpmc.book.model.User;

import java.util.List;

public interface UserService {

    void addUser(User user);

    List<User> getAllUsers();

}
