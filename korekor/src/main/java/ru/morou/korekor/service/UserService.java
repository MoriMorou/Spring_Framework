package ru.morou.korekor.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import ru.morou.korekor.entities.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    User findById(Long id);

    User findByUserName(String userName);

    boolean save(User user);

    List<User> findAll();

    boolean deleteUser(User user);

}