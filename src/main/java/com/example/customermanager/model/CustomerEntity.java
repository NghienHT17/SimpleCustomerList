package com.example.customermanager.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@NoArgsConstructor
@Table(name = "customer")
public class CustomerEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)//tự tăng ID lên
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;
    @Column(name = "gender")
    private String gender;
    @Column(name = "favourites")
    private String[] favorites;
    @Column(name = "posittion")
    private String position;




}