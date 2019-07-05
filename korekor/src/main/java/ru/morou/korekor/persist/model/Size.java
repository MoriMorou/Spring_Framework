package ru.morou.korekor.persist.model;

import javax.persistence.*;

@Entity
@Table(name = "size")
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "barcode-prefix", unique = true)
    private String barcodePrefix;

    @Column(name = "alpha_code")
    private String alphaCode;

    @Column(name = "status")
    private boolean status;

    public Size() {
    }

    public Size(String description, String barcodePrefix, String alphaCode, boolean status) {
        this.description = description;
        this.barcodePrefix = barcodePrefix;
        this.alphaCode = alphaCode;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBarcodePrefix() {
        return barcodePrefix;
    }

    public void setBarcodePrefix(String barcodePrefix) {
        this.barcodePrefix = barcodePrefix;
    }

    public String getAlphaCode() {
        return alphaCode;
    }

    public void setAlphaCode(String alphaCode) {
        this.alphaCode = alphaCode;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Size{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", barcodePrefix='" + barcodePrefix + '\'' +
                ", alphaCode='" + alphaCode + '\'' +
                ", status=" + status +
                '}';
    }
}
