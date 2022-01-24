package root.services;

import root.inter.UserRepository;
import root.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userDAO;

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public User addUser(User user) {
        User newUser = entityManager.merge(user);
        user.setId(newUser.getId());
        return newUser;
    }

    @Override
    @Transactional
    public User modifyUser(User user) {
        entityManager.merge(user);
        return user;
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        Query query = entityManager.createQuery("delete from User where id := userId");
        query.setParameter("userId", user.getId());
        query.executeUpdate();
    }

    @Override
    @Transactional
    public void deleteUsers() {
        userDAO.deleteAll();
    }

    @Override
    @Transactional
    public void deleteUserById(Integer id) {
        userDAO.deleteById(id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        Query query = entityManager.createQuery("from User");
        List<User> allUsers = query.getResultList();
        return allUsers;
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }
}
