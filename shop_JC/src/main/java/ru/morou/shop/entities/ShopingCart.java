package ru.morou.shop.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

import org.springframework.data.annotation.Id;

/**
 * Поскольку мы полагаетесь на базу данных для автоматического создания значения идентификатора, мы также аннотируем
 * свойство id с помощью @GeneratedValue, определяя стратегию AUTO.
 */

@Entity
@Data
public class ShopingCart {

    // FIXME: @GeneratedValue - проверить настройки
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    // FIXME: индификация заказа (потом убрать или переделать в поля для комментов)
    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    // время заказа
    private Date createdAt;

    @ManyToMany(targetEntity=Product.class)
    @Size(min=1, message="You must choose at least 1 product")
    private List<Product> products;

    /**
     * @PrePersist - аннотация необходима для отражения времени заказа
     */
    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}
