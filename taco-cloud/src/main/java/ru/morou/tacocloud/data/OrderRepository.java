package ru.morou.tacocloud.data;

import org.springframework.data.repository.CrudRepository;
import ru.morou.tacocloud.Order;


public interface OrderRepository
        extends CrudRepository<Order, Long> {

}