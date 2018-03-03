package com.prueba.springboot2.entity;



import javax.persistence.*;
import org.hibernate.validator.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name="Clients")
public class Client  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "description")
    private String description;
    @Column(name = "deleted")
    private Boolean deleted;


    public Client(){

    }

    public Client(String name, String lastName, String description, boolean deleted) {
        this.name = name;
        this.lastName = lastName;
        this.description = description;
        this.deleted = deleted;
    }


    public long getClientId() {
        return id;
    }

    public void setClientId(long id) {
        this.id = id;
    }

    public String getClientName() {
        return name;
    }

    public void setClientName(String name) {
        this.name = name;
    }

    public String getClientLastName() {
        return lastName;
    }

    public void setClientLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getClientDescription() {
        return description;
    }

    public void setClientDescription(String description) {
        this.description = description;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "Client{" +
                ", name='" + name + '\'' +
                ", lastName=" + lastName +
                '}';
    }


}































