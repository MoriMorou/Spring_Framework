package ru.morou.kore_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.morou.kore_shop.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    @Query("from Role r where name = :name")
    Role findOneByName(String name);
}
