package ru.morou.korekor.persist.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "qty")
    private int qty;

    @Column(name = "status")
    private boolean status;

    @ManyToOne(optional = false)
    private ProductTypes productTypes;

    @ManyToOne(optional = false)
    private Items items;

    @ManyToOne(optional = false)
    private Color color;

    @ManyToOne(optional = false)
    private Size size;

    // FIXME: 7/5/2019 доделать (внести в схему)
    @ManyToOne(optional = false)
    private Brand brand;

    // FIXME: 7/5/2019 доделать!!! упустила таблицу
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "products_categories",
            joinColumns = @JoinColumn(name = "products_id"),
            inverseJoinColumns = @JoinColumn(name = "categories_id"))
    private Set<Category> categories;

    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name = "pictures_products",
            joinColumns = @JoinColumn(name = "products_id"),
            inverseJoinColumns = @JoinColumn(name = "pictures_id"))
    private List<Picture> pictures;

    public Product() {
    }

    public Product(int qty, boolean status, ProductTypes productTypes, Items items, Color color, Size size, Brand brand, Set<Category> categories, List<Picture> pictures) {
        this.qty = qty;
        this.status = status;
        this.productTypes = productTypes;
        this.items = items;
        this.color = color;
        this.size = size;
        this.brand = brand;
        this.categories = categories;
        this.pictures = pictures;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ProductTypes getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(ProductTypes productTypes) {
        this.productTypes = productTypes;
    }

    public Items getItems() {
        return items;
    }

    public void setItems(Items items) {
        this.items = items;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", qty=" + qty +
                ", status=" + status +
                ", productTypes=" + productTypes +
                ", items=" + items +
                ", color=" + color +
                ", size=" + size +
                ", brand=" + brand +
                ", categories=" + categories +
                ", pictures=" + pictures +
                '}';
    }
}