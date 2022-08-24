package service;

import dao.UserDao;
import dao.UserDaoImpl;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@ComponentScan("dao")
public class UserServiceImpl implements UserService {
    UserDao userDao;
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
    public void save(User user) {
        userDao.save(user);
    }
    @Override
    public void update(User user) {
        userDao.update(user);
    }
    @Override
    public void delete(Long id) {
        userDao.delete(id);
    }
}
