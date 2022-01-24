package root.services;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import root.controllers.UserController;
import root.entity.User;
import root.inter.ToDoRepository;
import root.inter.UserRepository;

import javax.persistence.EntityManager;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class UserServiceImplTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EntityManager entityManager;

    @InjectMocks
    private UserController controller;
    @Mock
    IUserService userService;
    @Mock
    IToDoService toDoService;

    @Mock
    ToDoRepository toDoRepository;

    @Mock
    private UserRepository userRepository;


    @Test
    public void addUser() {
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        User user = new User(firstName, lastName);
        when(userRepository.save(user)).thenReturn(user);
        User response = controller.createUser(user);
        assertEquals(response.toString(),user.toString());

    }

    @Test
    void modifyUser() {
        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        User user = new User(firstName, lastName);
        when(userRepository.save(user)).thenReturn(user);
        User response = controller.createUser(user);
        assertEquals(response.toString(),user.toString());
        user.setUser_name("Newname");
        response = controller.modifyUser(user);
        assertEquals(response.toString(),user.toString());
    }

    @Test
    void getAllUsersEmpty() {
        List<User> allUsers = controller.getUsers();
        assert (allUsers.isEmpty());
    }

    @Test
    void getAllUsers() {
//        Faker faker = new Faker();
//
//        String firstName = faker.name().firstName();
//        String lastName = faker.name().lastName();
//        User user = new User(firstName, lastName);
////        when(userRepository.save(user)).thenReturn(user);
//        User response = controller.createUser(user);
//        assertEquals(response.toString(),user.toString());
//
//        List<User> allUsers = controller.getUsers();
//        assert (allUsers.isEmpty());
    }

    @Test
    void getUser() {
//        Faker faker = new Faker();
//
//        String firstName = faker.name().firstName();
//        String lastName = faker.name().lastName();
//        User user = new User(firstName, lastName);
//        when(userRepository.save(user)).thenReturn(user);
//        User response = controller.createUser(user);
//        assertEquals(response.toString(),user.toString());
//        when(userRepository.findById(user.getId()).get()).thenReturn(user);
//        when(userService.getUser(user.getId())).thenReturn(null);
//        response = controller.getUser(user.getId());
//        assertEquals(response.toString(),user.toString());
    }
}