package root.services;

import root.entity.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public List<User> getAllUsers();

    public User getUser(int id);

    public User addUser(User user);

    public User modifyUser(User user);

    public void deleteUser(User user);

    public void deleteUsers();

    public void deleteUserById(Integer id);
}
