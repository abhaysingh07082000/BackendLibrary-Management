package com.example.LibraryManagementSystem.RequestDto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class StudentRequestDto
{


    private int age;

    //must not null
    @Column(nullable = false)
    private String name;

    private String country;

//no duplicates values are allow
   @Column(name="school_email",unique = true,nullable = false)
    private String email;




}
