package root.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import root.entity.ToDo;
import root.entity.User;
import root.exceptions.NoDataException;
import root.services.IToDoService;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@RestController
public class ToDoController {

    @Autowired
    private IToDoService toDoService;

    @Autowired
    private EntityManager entityManager;

    @GetMapping("/todos")
    public List<ToDo> getAllTodos(){
        return toDoService.getAllTodo();
    }

    @GetMapping("/users/{userid}/todo/{id}")
    public ToDo getTodo(@PathVariable int id){
        ToDo toDo = toDoService.getTodo(id).get();
        if(toDo == null){
            throw new NoDataException("There is no user with id=" + id + " in database");
        }
        return toDo;
    }

    @PostMapping("/todo")
    public ToDo addSimpleTodo(@RequestBody ToDo toDo){
        return toDoService.addTodo(toDo);
    }

    @PostMapping("/users/{id}/todo")
    public ToDo addTodoWithoutUser(@RequestBody ToDo toDo){

        return toDoService.addTodo(toDo);
    }

    @PutMapping("/users/{id}/todo")
    public ToDo modifyTodo(@RequestBody ToDo toDo ){
        return toDoService.addTodo(toDo);
    }

    @DeleteMapping("/users/{id}/todo/{todoId}")
    public void deleteTodo(@PathVariable int todoId){
        toDoService.deleteTodoById(todoId);
    }

    @DeleteMapping("/todos")
    public void deleteTodos(){
        toDoService.deleteTodos();
    }
}
