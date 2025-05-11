package net.rashid.User_Demo.repositories;

import net.rashid.User_Demo.entities.Role;
import net.rashid.User_Demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
