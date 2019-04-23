package ru.morou.tacocloud;

import lombok.Data;
import lombok.RequiredArgsConstructor;


/**
 * Establishing the domain
 * @Ingrediemt - класс включает в себя такие объекты, как проекты Taco, компоненты, из которых состоят эти проекты,
 * клиенты, и заказы тако, сделанные клиентами.
 */


@Data
@RequiredArgsConstructor
public class Ingredient {

    private final String id;
    private final String name;
    private final Type type;

    public static enum Type{
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
