package me.mike.aims.model.entity;

import me.mike.aims.model.domain.ClientStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.util.UUID;

/**
 * @author Michael Keith
 */
@Entity
@Table(name = "Client")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Client {
    @Id
    private String id = UUID.randomUUID().toString();

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 28)
    private ClientStatus status = ClientStatus.PENDING;

    @Column(name = "firstName", nullable = false, length = 56)
    private String firstName;

    @Column(name = "lastName", nullable = false, length = 56)
    private String lastName;

    @Lob
    @Column(name = "waiver")
    private byte[] waiver;

    @Lob
    @Column(name = "waiver")
    private byte[] application;

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Client &&
                getId().equals(((Client) obj).getId());
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

    public ClientStatus getStatus() {
        return status;
    }

    public void setStatus(ClientStatus status) {
        this.status = status;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte[] getWaiver() {
        return waiver;
    }

    public void setWaiver(byte[] waiver) {
        this.waiver = waiver;
    }

    public byte[] getApplication() {
        return application;
    }

    public void setApplication(byte[] application) {
        this.application = application;
    }
}
