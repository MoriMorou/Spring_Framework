// tag::all[]
// tag::allButValidation[]
package ru.morou.tacocloud;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * Поскольку мы полагаетесь на базу данных для автоматического создания значения идентификатора, мы также аннотируем
 * свойство id с помощью @GeneratedValue, определяя стратегию AUTO.
 */

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String name;

    private Date createdAt;

    @ManyToMany(targetEntity=Ingredient.class)
    @Size(min=1, message="You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

    /**
     * @PrePersist - аннотация необходима для отражения времени заказа
     */
    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }
}