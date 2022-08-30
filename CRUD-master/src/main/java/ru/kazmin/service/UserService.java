package ru.kazmin.service;

import ru.kazmin.models.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    User getUser(Long id);
    void saveUser(User user);
    void updateUser(User user);
    void deleteUser(Long id);
}
