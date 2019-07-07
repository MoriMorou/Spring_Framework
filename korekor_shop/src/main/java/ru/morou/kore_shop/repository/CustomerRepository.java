package ru.morou.kore_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;
import ru.morou.kore_shop.entity.Customer;

/**
 * JpaRepository расширяет PagingAndSortingRepository который, в свою очередь, расширяет CrudRepository.
 * 1. CrudRepository основном предоставляет функции CRUD.
 * 2. PagingAndSortingRepository предоставляет методы для разбиения на страницы и сортировки записей.
 * 3. JpaRepository предоставляет некоторые связанные с JPA методы, такие как очистка контекста постоянства и удаление записей в пакете.
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("from Customers c join fetch c.roles r where c.customerName = :customerName")
    Customer findOneByCustomerName(String customerName);
}
