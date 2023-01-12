package com.example.LibraryManagementSystem.RequestDto;

import jakarta.persistence.Column;
import lombok.Data;



@Data
public class AuthorRequestDto
{
    private String name;

    @Column(unique = true)
    private String email;

    private int age;

    private String country;

}
