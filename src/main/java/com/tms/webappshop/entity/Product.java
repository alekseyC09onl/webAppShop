package com.tms.webappshop.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products", schema = "shop_schema")
public class Product implements Serializable {

    @Serial
    private static final long serialVersionUID = -1541071094346413382L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_product")
    private String nameProduct;

    @Column(name = "price")
    private Double price;

    @Column(name = "available_product")
    private boolean availableProduct;

    @ManyToMany
    @JoinTable(name = "products_orders",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private Set<Order> orderSet;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return availableProduct == product.availableProduct && Objects.equals(id, product.id) && Objects.equals(nameProduct, product.nameProduct) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nameProduct, price, availableProduct);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", availableProduct=" + availableProduct +
                ", orderSet=" + orderSet +
                '}';
    }
}
