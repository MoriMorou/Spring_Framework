package ru.morou.kore_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import ru.morou.kore_shop.entity.User;

/**
 * JpaRepository расширяет PagingAndSortingRepository который, в свою очередь, расширяет CrudRepository.
 * 1. CrudRepository основном предоставляет функции CRUD.
 * 2. PagingAndSortingRepository предоставляет методы для разбиения на страницы и сортировки записей.
 * 3. JpaRepository предоставляет некоторые связанные с JPA методы, такие как очистка контекста постоянства и удаление записей в пакете.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * @Querty (данные; запрос; [заголовки])
     * @param userName
     * @return
     */
    @Query("from User u join fetch u.roles r where u.userName = :userName")
    User findOneByUserName(String userName);
}
