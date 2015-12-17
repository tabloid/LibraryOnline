package GVA.LibraryOnline.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * Created by V.Herasymenko on 13.10.2015.
 */
@Entity
@Table(name = "books")
public class EntityBook {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "books_id_seq")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;
    @Column(name = "year")
    private String year;
    @Column(name = "extention")
    @JsonIgnore
    private String extention;
    @OneToOne(cascade = CascadeType.ALL)
    private EntityFeature entityFeature;
    @Column(name = "title")
    private byte[] title;
    @Column(name = "data")
    @JsonIgnore
    private byte[] data;

    public EntityBook(int id, EntityFeature feature, String name,
                      String author, String year, String extention, byte[] title) {
        this.id = id;
        this.entityFeature = feature;
        this.name = name;
        this.author = author;
        this.year = year;
        this.extention = extention;
        this.title = title;
    }

    public EntityBook() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFeature() {
        return entityFeature.getFeature();
    }

    public void setFeature(EntityFeature entityFeature) {
        this.entityFeature = entityFeature;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public String getExtention() {
        return extention;
    }

    public void setExtention(String extention) {
        this.extention = extention;
    }

    public byte[] getTitle() {
        return title;
    }

    public void setTitle(byte[] title) {
        this.title = title;
    }
}
