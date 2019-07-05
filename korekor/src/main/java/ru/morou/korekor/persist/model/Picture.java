package ru.morou.korekor.persist.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "pictures")
public class Picture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Lob
    @Column(name = "picture_data", nullable = false, columnDefinition="MEDIUMBLOB")
    private byte[] picture_data;

    @Column(name = "content_type", nullable = false)
    private String contentType;

    @ManyToMany(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinTable(name = "pictures_types",
            joinColumns = @JoinColumn(name = "pictures_id"),
            inverseJoinColumns = @JoinColumn(name = "types_id"))
    private List<PictureType> pictureTypes;

    @ManyToMany(mappedBy = "pictures")
    private List<Product> products;

    public Picture() {
    }

}

