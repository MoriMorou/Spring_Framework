package ru.morou.korekor.service;

import org.junit.Before;
import org.junit.Test;
import ru.morou.korekor.controller.repr.ProductRepr;
import ru.morou.korekor.service.repr.ProductInfo;

import java.math.BigDecimal;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class TestCartService {

    private CartService cartService;

    @Before
    public void init(){
        cartService = new CartServiceImpl();
    }

    @Test
    public void testAddOneProduct(){
        ProductRepr expectedProduct = new ProductRepr();
        expectedProduct.setId(1L);
        expectedProduct.setName("Test product");
        expectedProduct.setPrice(new BigDecimal(111));

        ProductInfo expectedProductInfo = new ProductInfo();
        expectedProductInfo.setSize("size");
        expectedProductInfo.setColor("colour");
        expectedProductInfo.setProduct(expectedProduct);
        cartService.addItemQty(expectedProductInfo, 1);

        Map<ProductInfo, Integer> allItems= cartService.findAllItems();
        assertEquals(allItems.size(), 1);
        assertEquals((long) allItems.get(expectedProductInfo), 1);
        assertEquals((long) cartService.getItemsQty(), 1);
    }
}
