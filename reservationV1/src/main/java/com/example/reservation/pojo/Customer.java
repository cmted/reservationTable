package com.example.reservation.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "customer")
@Data
public class Customer {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer customerId;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "people")
    private Integer people;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="table_id",referencedColumnName = "tableId")
    @JsonIgnoreProperties("customer")
    private Retable retable;

    public Customer(String name, String email, String phone, Integer people, Retable retable) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.people = people;
        this.retable = retable;
    }

    public Customer() {

    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPeople() {
        return people;
    }

    public void setPeople(Integer people) {
        this.people = people;
    }

    public Retable getRetable() {
        return retable;
    }

    public void setRetable(Retable retable) {
        this.retable = retable;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", people=" + people +
                ", retable=" + retable +
                '}';
    }
}
