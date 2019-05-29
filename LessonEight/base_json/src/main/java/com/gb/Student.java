package com.gb;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * JSON (JavaScript Object Notation) - это легкий формат, который используется для обмена данными.
 * JSON построен на двух структурах:
 *
 * Коллекция пар имя/значение. На разных языках это реализуется как объект, запись, структура, словарь, хеш-таблица, список клавиш или ассоциативный массив.
 * Упорядоченный список значений. В большинстве языков это реализуется как массив, вектор, список или последовательность.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Student {
    private int id;
    private String name;
    private int[] mass;
    private int age;

    public Student() {
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
        this.mass = new int[]{1, 2, 3, 4};
        this.age = 13;
    }

    /**
     * Нужны гетторы а то json private поля не берет
     * @return
     */
    public int[] getMass() {
        return mass;
    }

    public void setMass(int[] mass) {
        this.mass = mass;
    }

//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void info() {
        System.out.println(id + " " + name);
    }
}
