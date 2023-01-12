package com.example.LibraryManagementSystem.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Author
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     private int id;

    private String name;

    @Column(unique = true)
    private String email;

    private int age;

    private String country;

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book>booksWritten;

}
