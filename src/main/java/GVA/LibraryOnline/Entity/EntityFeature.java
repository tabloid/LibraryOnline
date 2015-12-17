package GVA.LibraryOnline.Entity;

import javax.persistence.*;

/**
 * Created by V.Herasymenko on 17.12.2015.
 */
@Entity
@Table(name = "features")
public class EntityFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq_gen")
    @SequenceGenerator(name = "users_seq_gen", sequenceName = "books_id_seq")
    private int id;
    @JoinColumn
    private String feature;

    public EntityFeature(String feature) {
        this.feature = feature;
    }

    public EntityFeature() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }
}
