package ma.emsi.jpaem.service;

import ma.emsi.jpaem.entities.Role;
import ma.emsi.jpaem.entities.User;

public interface UserService {

    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String username,String roleName);
    User authentification(String userName,String password);
}
