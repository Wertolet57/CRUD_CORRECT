package ru.kazmin.service;

import ru.kazmin.dao.UserDao;
import ru.kazmin.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component("userService")
@ComponentScan("ru.kazmin.dao")
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    @Autowired
    public UserServiceImpl(UserDao userDAO) {
        this.userDao = userDAO;
    }
    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }
    @Override
    public User getUser(Long id) {
        return userDao.getUser(id);
    }
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }
}
