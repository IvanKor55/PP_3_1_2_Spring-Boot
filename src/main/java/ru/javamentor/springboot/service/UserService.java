package ru.javamentor.springboot.service;
import ru.javamentor.springboot.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);
    void editUser(User user);
    void deleteUser(User user);
    List<User> getListUsers();
    User getUser (Integer id);
}
