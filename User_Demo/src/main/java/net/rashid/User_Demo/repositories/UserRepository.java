package net.rashid.User_Demo.repositories;

import net.rashid.User_Demo.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , String> {
    User findByUsername(String username);
}
