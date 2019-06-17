//package ru.morou.shop.entities;
//
//import lombok.AccessLevel;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.RequiredArgsConstructor;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//
///**
// * Establishing the domain
// * @Category - класс включает в себя объекты, описывающие товары
// * Чтобы объявить это как сущность JPA, Ingredient должен быть помечен @Entity. И его свойство id должно быть
// * аннотировано @Id, чтобы обозначить его как свойство, которое будет уникально идентифицировать сущность в базе данных.
// *
// * @NoArgsConstructor от Lombok - конструктор без аргументов так как AccessLevel.PRIVATE (ограничивает доступ)
// * @Data неявно добавляет необходимый конструктор аргументов, но когда используется @NoArgsConstructor, этот конструктор
// * получает статус удален.
// * @RequiredArgsConstructor гарантирует, что у нас все еще будет необходимый конструктор аргументов в дополнение к
// * частному конструктору без аргументов.
// */
//
//@Entity
//@Data
//@RequiredArgsConstructor
//@NoArgsConstructor(access= AccessLevel.PRIVATE, force=true)
//public class Product {
//
//    @Id
//    private final String id;
//    private final String factory_id;
//    private final String name;
//    private final Type type;
//    private final String country;
//    private final float size;
//    private final String colour;
//    private final String material;
//    private final String text;
//    private final float price;
//    private final String currency;
//    private final String fileName;
//
//    public static enum Type {
//        MENSCLOTHES,
//        WOMENSCLOTHES,
//        BABYCLOTHES,
//        MENSSHOES,
//        WOMENSSHOES,
//        BABYSHOES,
//        ACCESSORIES,
//        OTHER;
//    }
//}