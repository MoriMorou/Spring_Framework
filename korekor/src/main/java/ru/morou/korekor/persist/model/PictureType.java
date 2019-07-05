package ru.morou.korekor.persist.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "picture_types")
public class PictureType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;


    @ManyToMany(mappedBy = "pictures_types")
    private List<Picture> pictures;

    public PictureType() {
    }

    public PictureType(String name, List<Picture> pictures) {
        this.name = name;
        this.pictures = pictures;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

    @Override
    public String toString() {
        return "PictureType{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pictures=" + pictures +
                '}';
    }
}
