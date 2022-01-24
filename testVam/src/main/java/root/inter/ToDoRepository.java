package root.inter;

import org.springframework.data.jpa.repository.JpaRepository;
import root.entity.ToDo;

public interface ToDoRepository extends JpaRepository<ToDo, Integer> {

}
