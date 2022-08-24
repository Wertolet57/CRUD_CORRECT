package dao;

import models.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    User getUser(Long id);
    void save(User user);
    void update(User user);
    void delete(Long id);
}
