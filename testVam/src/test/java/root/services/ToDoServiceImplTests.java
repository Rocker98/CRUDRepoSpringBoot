package root.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import root.controllers.ToDoController;
import root.controllers.UserController;
import root.entity.ToDo;
import root.inter.ToDoRepository;
import root.inter.UserRepository;

import javax.persistence.EntityManager;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ToDoServiceImplTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private EntityManager entityManager;

    @InjectMocks
    private UserController UserController;

    @InjectMocks
    private ToDoController toDoController;
    @Mock
    IUserService userService;
    @Mock
    IToDoService toDoService;

    @Mock
    ToDoRepository toDoRepository;

    @Mock
    private UserRepository userRepository;


    @Test
    public void addTodo() {
//        ToDo toDo = new ToDo("Create test");
//        when(toDoRepository.save(toDo)).thenReturn(toDo);
//        ToDo response = toDoController.addSimpleTodo(toDo);
//        assertEquals(response.toString(),toDo.toString());
    }

    @Test
    void modifyUser() {
//        Faker faker = new Faker();
//
//        String firstName = faker.name().firstName();
//        String lastName = faker.name().lastName();
//        User user = new User(firstName, lastName);
//        when(userRepository.save(user)).thenReturn(user);
//        User response = controller.createUser(user);
//        assertEquals(response.toString(),user.toString());
//        user.setUser_name("Newname");
//        response = controller.modifyUser(user);
//        assertEquals(response.toString(),user.toString());
    }

    @Test
    void getAllUsersEmpty() {
        List<ToDo> allTodos = toDoController.getAllTodos();
        assert (allTodos.isEmpty());
    }

    @Test
    void getAllUsers() {

        ToDo toDo = new ToDo("Test todo");
//        when(userRepository.save(user)).thenReturn(user);
        toDoController.addSimpleTodo(toDo);

        List<ToDo> allTodos = toDoController.getAllTodos();
        assert (allTodos.isEmpty());
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
