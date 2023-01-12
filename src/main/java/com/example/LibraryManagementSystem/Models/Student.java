package com.example.LibraryManagementSystem.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.*;
@Entity
@Table(name="student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @Column(name="school_email",unique = true,nullable = false)
    private String email;


    private int age;


    @Column(columnDefinition = "varchar2(255) 'India'")
    private String country;


    //bidirectional connection of the tables
    //this is for cascading and consistency

    @OneToOne(mappedBy = "student",cascade = CascadeType.ALL)
    private Card card;



    //it will create data and time at the time of creation

    @CreationTimestamp
    private Date createdOn;


    //it will update time and date as we modify anything

    @UpdateTimestamp
    private Date updatedOn;

    public Student(String name,String email,int age,String country)
    {

        this.name = name;
        this.email=email;
        this.age=age;
        this.country=country;

    }


}
