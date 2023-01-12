package com.example.LibraryManagementSystem.Convertors;

import com.example.LibraryManagementSystem.Models.Author;
import com.example.LibraryManagementSystem.RequestDto.AuthorRequestDto;

public class AuthorConvertor
{


    public static Author convertDtoToEntity(AuthorRequestDto authorRequestDto)
    {

        Author author=Author.builder().name(authorRequestDto.getName())
                                           .email(authorRequestDto.getEmail()) .age(authorRequestDto.getAge())
                                                                                           .country(authorRequestDto.getCountry()).build();
        return author;
    }
}
