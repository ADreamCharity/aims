package me.mike.aims.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * @author Michael Keith
 */
@Entity
@Table(name = "Phone")
public class Phone {
    @Id
    private String id = UUID.randomUUID().toString();

    @Column(length = 10, nullable = false)
    private String number;

    @Override
    public String toString() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Phone &&
                getId().equals(((Phone) obj).getId());
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
