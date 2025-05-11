package net.rashid.User_Demo.services;

import jakarta.transaction.Transactional;
import net.rashid.User_Demo.entities.Role;
import net.rashid.User_Demo.entities.User;
import net.rashid.User_Demo.repositories.RoleRepository;
import net.rashid.User_Demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public User addNewUser(User user) {
        user.setId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public User findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        User user = findUserByUsername(username);
        Role role = findRoleByRoleName(roleName);
        if(user.getRoles()!=null && role.getUsers()!=null) {
            user.getRoles().add(role);
            role.getUsers().add(user);
        }
    }

    @Override
    public User authentificate(String username, String password) {
        User user = findUserByUsername(username);
        if(user==null){
            throw new RuntimeException("Bad authentificate");
        }
        if(user.getPassword().equals(password)){
            return user;
        }
        throw new RuntimeException("Bad authentificate");
    }

}
