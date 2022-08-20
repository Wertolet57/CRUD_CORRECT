package service;

import dao.UserDAO;
import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@ComponentScan("dao")
public class UserService {
    UserDAO userDAO;
    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    public List<User> getUsers() {
        return userDAO.getUsers();
    }
    public User getUser(Long id) {
        return userDAO.getUser(id);
    }
    public void save(User user) {
        userDAO.save(user);
    }
    public void update(User user) {
        userDAO.update(user);
    }
    public void delete(Long id) {
        userDAO.delete(id);
    }
}
