package space.wudi.todolist.persisitance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import space.wudi.todolist.persisitance.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
