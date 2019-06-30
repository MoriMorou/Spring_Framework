package ru.morou.korekor.service;

import java.math.BigDecimal;

public interface CartService {

    void addItemQty(ProductInfo productInfo, int qty);

    void removeItemQty(ProductInfo productInfo, int qty);

    void removeItem(ProductInfo productInfo);

    Map<ProductInfo, Integer> findAllItems();

    Integer getItemQty();

    BigDecimal getSubTotal();
}
