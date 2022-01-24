package root;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import root.TestVamApplication;
import root.controllers.UserController;
import root.entity.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = TestVamApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestVamApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void testRootPath(){
		assertEquals("Hello from root",
				testRestTemplate.getForObject("http://localhost:" + port + "/",
						String.class));
	}

	@Test
	public void testGetUserById(){
		assertEquals("{\"id\":1,\"user_name\":\"Volodymyr\",\"surname\":\"Petruniak\"}",
				testRestTemplate.getForObject("http://localhost:" + port + "/users/1",
						String.class));
	}

	@Test
	public void createRandUser(){
		Faker faker = new Faker();

		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		User user = new User(firstName, lastName);
		int endIndex = 42+firstName.length()+lastName.length(); //deleted unneeded info after request
		int startIndex = 14; //deleted first part of string
		assertEquals("\"user_name\":\"" + firstName + "\",\"surname\":\"" + lastName + "\"}",
				testRestTemplate.postForEntity("http://localhost:" + port + "/user",
						user, String.class).toString().substring(startIndex,endIndex));
	}

//	@Test
//	public void testGetById(){
//		UserController userController = new UserController();
//		assertEquals("{\"id\":1,\"user_name\":\"Volodymyr\",\"surname\":\"Petruniak\"}",
//				userController.getUser(1));
//	}

}
