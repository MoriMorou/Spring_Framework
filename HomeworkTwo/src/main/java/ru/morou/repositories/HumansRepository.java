package ru.morou.repositories;

import org.springframework.stereotype.Component;
import ru.morou.entites.Human;

/**
 * Хранилище (эмитация базы данных)
 */

@Component
public class HumansRepository {

    public Human findOneByID(int id){
        Human human = new Human();
        human.setFirstName("Ivan " + id);
        human.setLastName("Ivanov " +id);
        return human;
    }
}
