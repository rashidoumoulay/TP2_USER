package net.rashid.User_Demo.services;

import net.rashid.User_Demo.entities.Role;
import net.rashid.User_Demo.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUsername(String username);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username , String roleName);
    User authentificate(String username , String password);
}
