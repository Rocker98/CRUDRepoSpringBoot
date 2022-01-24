package root.controllers;

import root.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import root.exceptions.NoDataException;
import root.services.IToDoService;
import root.services.IUserService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IToDoService toDoService;


    @GetMapping("/")
    public String tetsMap(){
        return "Hello from root";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers(){
        List<User> allUsers = userService.getAllUsers();
        return allUsers;
    }

    @RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable int id){
        User user = userService.getUser(id);
        if(user == null){
            throw new NoDataException("There is no user with id=" + id + " in database");
        }
        return user;
    }

    @PostMapping(value = "/user")
    public User createUser(@RequestBody User user){
        userService.addUser(user);
        return user;
    }

    @PutMapping(value = "/user")
    public User modifyUser(@RequestBody User user){
        userService.modifyUser(user);
        return user;
    }

    @DeleteMapping(value = "/user")
    public User deleteUser(@RequestBody User user){
        userService.deleteUser(user);
        return user;
    }

    @DeleteMapping(value = "/users")
    public void deleteUsers(){
        userService.deleteUsers();
    }

    @DeleteMapping(value = "/users/{id}")
    public void deleteUserById(@PathVariable int id){
        userService.deleteUserById(id);
    }

}
