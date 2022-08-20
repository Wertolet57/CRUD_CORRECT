package dao;

import models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class UserDAO {
    @PersistenceContext()
    private EntityManager entityManager;

    public List<User> getUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }
    public User getUser(Long id) {
        return entityManager.find(User.class, id);
    }
    public void save(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }
    public void update(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }
    public void delete(Long id) {
        entityManager.remove(getUser(id));
        entityManager.flush();
    }
}
