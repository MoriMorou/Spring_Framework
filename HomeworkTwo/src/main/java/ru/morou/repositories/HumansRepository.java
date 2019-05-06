package ru.morou.repositories;

import org.springframework.stereotype.Component;
import ru.morou.entites.Human;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Хранилище (эмитация базы данных)
 * https://www.boraji.com/index.php/java-8-bifunction-interface-example
 */

@Component
public class HumansRepository {
    private static final Map<Human, String> humans = new HashMap<>();

    static {
        humans.put(
                new Human("Mori", "Morou", "Female", "University"), "manager");
        humans.put(
                new Human("Dany", "Morou", "Male", "School"), "pupil");
        humans.put(
                new Human("Mikko", "Suom", "Male", "MBA and other"), "director");
    }

    public String getInfo(final Human human) {
        return humans.get(human);
    }

    public List<Human> getHumans() {
        return new ArrayList<>(humans.keySet());
    }
}
