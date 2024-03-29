package ru.morou.homework_seven.services;

import ru.morou.homework_seven.entities.Role;
import ru.morou.homework_seven.entities.SystemUser;
import ru.morou.homework_seven.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findByUserName(String userName);

    void save(SystemUser systemUser);

    /////////////////////////////////
    List<Role> getAllRoles();
}
