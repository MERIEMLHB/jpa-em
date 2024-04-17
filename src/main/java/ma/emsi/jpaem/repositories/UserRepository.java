package ma.emsi.jpaem.repositories;

import ma.emsi.jpaem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {
    User findByUsername(String userName);
}
