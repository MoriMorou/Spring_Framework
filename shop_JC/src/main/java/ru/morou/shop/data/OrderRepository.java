package ru.morou.shop.data;

import org.springframework.data.repository.CrudRepository;
import ru.morou.shop.entities.Order;

public interface OrderRepository extends CrudRepository<Order, Long> {

//    List<Order> findByDeliveryZip(String deliveryZip);

//    List<Order> readOrdersByDeliveryZipAndPlacedAtBetween(
//            String deliveryZip, Date startDate, Date endDate);


//    List <Order> findByDeliveryToAndDeliveryCityAllIgnoresCase (
//            String deliveryTo, String deliveryCity);


//    @Query("Order o where o.deliveryCity='Seattle'")
//    List<Order> readOrdersDeliveredInSeattle();
}
