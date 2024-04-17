package ma.emsi.jpaem.repositories;

import ma.emsi.jpaem.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role,String> {
    Role findByRoleName(String roleName);
}
