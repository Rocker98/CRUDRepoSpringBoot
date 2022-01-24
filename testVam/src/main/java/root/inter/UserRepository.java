package root.inter;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import root.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {
}
