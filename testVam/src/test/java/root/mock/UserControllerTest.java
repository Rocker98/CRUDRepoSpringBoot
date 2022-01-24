package root.mock;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import root.inter.UserRepository;
import root.services.IToDoService;
import root.services.IUserService;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UserControllerTest {

    @MockBean
    private IUserService userService;

    @MockBean
    private IToDoService toDoService;

    @MockBean
    private EntityManager entityManager;

    @MockBean
    private UserRepository userDAO;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void findAll(){

        try {
            mockMvc.perform(MockMvcRequestBuilders.get("/users")).andExpect(MockMvcResultMatchers.status().isOk());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void findFirstUser(){

//        Faker faker = new Faker();
//
//        String firstName = faker.name().firstName();
//        String lastName = faker.name().lastName();
//        User user = new User(firstName, lastName);
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append("{\"user_name\":\"" + firstName + "\",\"surname\":\"" + lastName + "\"}");
//        userService.addUser(user);
//        when(userDAO.save(user)).thenReturn(user);
//        try {
//            mockMvc.perform(MockMvcRequestBuilders.get("/users/1")).andExpect(MockMvcResultMatchers.status().isOk());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


    }

    @Test
    public void createUser(){

        Faker faker = new Faker();

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{\"user_name\":\"" + firstName + "\",\"surname\":\"" + lastName + "\"}");
    try {
        mockMvc.perform(MockMvcRequestBuilders.post("/user").contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).content(stringBuilder.toString())).andExpect(MockMvcResultMatchers.status().isOk());
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}
