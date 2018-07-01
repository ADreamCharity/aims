package me.mike.aims.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * TODO Types ?
 * @author Michael Keith
 */
@Entity
@Table(name = "Address")
public class Address {
    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "street1", nullable = false, length = 128)
    private String street1;

    @Column(name = "street2", length = 128)
    private String street2;

    @Column(name = "city", nullable = false, length = 56)
    private String city;

    @Column(name = "state", nullable = false, length = 2)
    private String state;

    @Column(name = "zip", nullable = false, length = 9)
    private String zip;

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Address &&
                getId().equals(((Address) obj).getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    public UUID getId() {
        return UUID.fromString(id);
    }

    protected void setId(String id) {
        this.id = id;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
}
