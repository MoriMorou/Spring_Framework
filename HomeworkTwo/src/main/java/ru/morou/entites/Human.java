package ru.morou.entites;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

/**
 * https://www.boraji.com/index.php/java-8-bifunction-interface-example
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Human {

    private Human parent;
    private List<Human> children = new ArrayList<>();
    private String firstName;
    private String lastName;
    private String sex;
    private String education;

    @Override
    public boolean equals(final Object other) {

        if(other == this) return true;
        if(!(other instanceof Human)) return false;
        final Human otherHuman = (Human) other;

        BiFunction<Object, Object, Boolean> function = (Object object1, Object object2) -> {
            if(object1 == null && object2 == null) return true;
            if(object1 == null && object2 != null) return false;
            return object1.equals(object2);
        };

        boolean result = true;
        result = result && function.apply(this.firstName, otherHuman.firstName);
        result = result && function.apply(this.lastName, otherHuman.lastName);

        return result;
    }

    @Override
    public int hashCode() {
        String name;
        if(firstName == null)
            name = "";
        else
            name = firstName;

        name += lastName;
        return name.hashCode();
    }

}