package ru.morou.homework_seven.repositories;

import ru.morou.homework_seven.entities.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findOneByName(String roleName);
}
