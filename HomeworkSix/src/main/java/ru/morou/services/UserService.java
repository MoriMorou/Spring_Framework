package ru.morou.services;

import ru.morou.entities.Role;
import ru.morou.entities.SystemUser;
import ru.morou.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(SystemUser systemUser);

    /////////////////////////////////
    List<Role> getAllRoles();
}
