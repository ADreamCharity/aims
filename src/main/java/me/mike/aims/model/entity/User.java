package me.mike.aims.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * TODO Roles.
 * @author Michael Keith
 */
@Entity
@Table(name = "User")
public class User {
    @Id
    private String id = UUID.randomUUID().toString();

    @Column(name = "username", nullable = false, length = 56)
    private String username;

    @Column(name = "password", nullable = false, length = 512)
    private String password;

    @Column(name = "email", nullable = false, length = 128)
    private String email;

    @Column(name = "lastName", nullable = false, length = 56)
    private String lastName;

    @Column(name = "firstName", nullable = false, length = 56)
    private String firstName;

    @ManyToMany
    @JoinTable(name = "UserPhone",
               joinColumns        = { @JoinColumn(name = "userId",  referencedColumnName = "id", nullable = false) },
               inverseJoinColumns = { @JoinColumn(name = "phoneId", referencedColumnName = "id", nullable = false) })
    private Set<Phone> phones = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "UserAddress",
            joinColumns        = { @JoinColumn(name = "userId",    referencedColumnName = "id", nullable = false) },
            inverseJoinColumns = { @JoinColumn(name = "addressId", referencedColumnName = "id", nullable = false) })
    private Set<Address> addresses = new HashSet<>();

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof User &&
                getId().equals(((User) obj).getId());
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Set<Phone> getPhones() {
        return Collections.unmodifiableSet(new HashSet<>(phones));
    }

    protected void setPhones(Set<Phone> phone) {
        this.phones = phone;
    }

    public Set<Address> getAddresses() {
        return Collections.unmodifiableSet(new HashSet<>(addresses));
    }

    protected void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }
}
