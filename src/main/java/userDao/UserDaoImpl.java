package userDao;

import org.springframework.stereotype.Repository;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return this.entityManager;
    }


    @Override
    public List<User> allUsers() {
        List<User> userList = getEntityManager()
                .createQuery("FROM User")
                .getResultList();
        return userList;

    }

    @Override
    public void add(User user) {
        getEntityManager().persist(user);
    }


    @Override
    public void delete(int id) {
        getEntityManager()
                .createQuery("delete from User where id=: id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void edit(User user) {
        getEntityManager().merge(user);

    }

    @Override
    public User getById(int id) {
        return getEntityManager().find(User.class, id);

    }
}