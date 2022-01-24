package root.services;

import root.entity.ToDo;

import java.util.List;
import java.util.Optional;

public interface IToDoService {
    public List<ToDo> getAllTodo();

    public ToDo addTodo(ToDo toDo, int id);

    public ToDo addTodo(ToDo toDo);

    public Optional<ToDo> getTodo(int id);

    public ToDo modifyTodo(ToDo toDo);

    public void deleteTodo(ToDo toDo);

    public void deleteTodoById(int id);

    public void deleteTodos();
}
