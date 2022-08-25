package com.example.reservation.pojo;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "retable")
@Data
public class Retable {

    @Id
    @GeneratedValue
    @Column(name = "tableId")
    private Integer tableId;

    @Column(name = "tableNum", unique = true)
    private String tableNum;

    @OneToOne(mappedBy = "retable")
    private Customer customer;

}
