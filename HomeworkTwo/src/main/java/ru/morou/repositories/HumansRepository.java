package ru.morou.repositories;

import org.springframework.stereotype.Component;
import ru.morou.entites.Human;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Хранилище (эмитация базы данных)
 */

@Component
public class HumansRepository {
    private Human root;

    private void add(Human human, Human parent) {
        if(parent == null) {
            root = human;
            return;
        }

        Human foundParent = find(parent);
        if(foundParent == null) return;
        foundParent.getChildren().add(human);
    }

    private static Human find(Human humanForm, Human human) {
        if(humanForm.equals(human)) return humanForm;
        for(Human child: humanForm.getChildren()) {
            Human match = find(child, human);
            if(match != null) return match;
        }

        return null;
    }

    public Human find(Human human) {
        return find(root, human);
    }

    private static void forEach(Human humanForm, Consumer<Human> consumer) {
        consumer.accept(humanForm);
        for(Human child: humanForm.getChildren()) {
            forEach(child, consumer);
        }
    }

    public void forEach(Consumer<Human> consumer) {
        forEach(root, consumer);
    }

    HumansRepository() {
        Human h1 = new Human();
        h1.setFirstName("Mori");
        h1.setLastName("Morou");
        h1.setSex("Female");
        h1.setEducation("MBA and other");

        Human h2 = new Human();
        h2.setFirstName("Dany");
        h2.setLastName("Morou");
        h2.setSex("Male");
        h2.setEducation("School");

        Human h3 = new Human();
        h3.setFirstName("Mikko");
        h3.setLastName("Suom");
        h3.setSex("Male");
        h3.setEducation("MBA and other");

        Human h4 = new Human();
        h4.setFirstName("Mikko");
        h4.setLastName("Nisin");
        h4.setSex("Male");
        h4.setEducation("University");

        Human h5 = new Human();
        h5.setFirstName("Alina");
        h5.setLastName("Lorte");
        h5.setSex("Female");
        h5.setEducation("University");

        Human h6 = new Human();
        h6.setFirstName("Alina");
        h6.setLastName("Lorte");
        h6.setSex("Female");
        h6.setEducation("University");

        add(h1, null);
        add(h2, null);
        add(h3, h1);
        add(h4, h3);
        add(h5, h4);
        add(h6, null);
    }

    public String getData(final Human human) {
        return find(human).toString();
    }

    public List<Human> getHumans() {
        final List<Human> result = new ArrayList<>();
        forEach(result::add);
        return result;
    }
}