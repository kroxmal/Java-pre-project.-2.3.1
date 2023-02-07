package web.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import web.model.User;

import javax.persistence.*;
import java.util.List;

@Component
@Transactional
public class UserDao {
    @PersistenceContext
    private EntityManager entityManager;


    public List<User> allUsers() {
        TypedQuery<User> typedQuery = entityManager.createQuery("from User", User.class);
        return typedQuery.getResultList();
    }


    public void add(User user) {
        entityManager.persist(user);
    }


    public void delete(User user) {
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }


    public void edit(User user) {
        entityManager.merge(user);
    }


    public User getById(int id) {
        return entityManager.find(User.class, id);
    }

}
