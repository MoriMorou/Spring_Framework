package ru.morou.shop.entities;


import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Table(name = "client_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    // FIXME: 6/17/2019 проверить настройки GenerationType
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date placedAt;

    @ManyToOne
    private User user;

    @NotBlank(message="Delivery name is required")
    private String deliveryName;

    @NotBlank(message="Street is required")
    private String deliveryStreet;

    @NotBlank(message="City is required")
    private String deliveryCity;

    @NotBlank(message="Region is required")
    private String deliveryRegion;

    @NotBlank(message="Country is required")
    private String deliveryCountry;

    @NotBlank(message="Zip code is required")
    private String deliveryZip;

    @NotBlank(message = "Phone number is required")
    private String phoneNumber;

    @Email(message = "Phone number is required")
    private String email;

    @CreditCardNumber(message="Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$",
            message="Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;

    @ManyToMany(targetEntity=ShopingCart.class)
    private List<ShopingCart> shopingCarts = new ArrayList<>();

    public void addShopingCart(ShopingCart shopingCart) {
        this.shopingCarts.add(shopingCart);
    }

    @PrePersist
    void placedAt() {
        this.placedAt = new Date();
    }

}
