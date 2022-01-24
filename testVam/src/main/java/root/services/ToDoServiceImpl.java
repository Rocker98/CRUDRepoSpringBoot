package root.services;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import root.inter.ToDoRepository;
import root.inter.UserRepository;
import root.entity.ToDo;
import root.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Service
public class ToDoServiceImpl implements IToDoService {
    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private UserServiceImpl userService;

    @Override
    @Transactional
    public List<ToDo> getAllTodo() {
//        return toDoRepository.findAll();
        Query query = entityManager.createQuery("from ToDo");
        List<ToDo> allTodos = query.getResultList();
        return allTodos;
    }

    @Override
    @Transactional
    public ToDo addTodo(ToDo toDo, int id) {
        userService.getUser(id).addTodoToUser(toDo);
        return toDoRepository.save(toDo);
    }

    @Override
    @Transactional
    public ToDo addTodo(ToDo toDo) {
        return entityManager.merge(toDo);
    }

    @Override
    public Optional<ToDo> getTodo(int id) {
        return toDoRepository.findById(id);
    }

    @Override
    @Transactional
    public ToDo modifyTodo(ToDo toDo) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(toDo);
        return toDo;
    }

    @Override
    @Transactional
    public void deleteTodo(ToDo toDo) {
        toDoRepository.delete(toDo);
    }

    @Override
    @Transactional
    public void deleteTodoById(int id) {

        toDoRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteTodos() {
        toDoRepository.deleteAll();
    }
}
