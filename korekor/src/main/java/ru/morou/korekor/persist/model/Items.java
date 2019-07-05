package ru.morou.korekor.persist.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "items")
public class Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name="description")
    private String description;

    @Column(name="full_description")
    private String full_description;


    public Items() {
    }

    public Items(String name, BigDecimal price, String description, String full_description) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.full_description = full_description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFull_description() {
        return full_description;
    }

    public void setFull_description(String full_description) {
        this.full_description = full_description;
    }

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", full_description='" + full_description + '\'' +
                '}';
    }
}
