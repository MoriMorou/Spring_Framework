package ru.morou.shop.data;

import org.springframework.data.repository.CrudRepository;
import ru.morou.shop.entities.ShopingCart;

public interface ShopingCartRepository extends CrudRepository<ShopingCart, Long> {
}
