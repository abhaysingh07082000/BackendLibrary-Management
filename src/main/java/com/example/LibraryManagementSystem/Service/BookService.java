package com.example.LibraryManagementSystem.Service;

import com.example.LibraryManagementSystem.Convertors.BookConvertor;
import com.example.LibraryManagementSystem.Models.Author;
import com.example.LibraryManagementSystem.Models.Book;
import com.example.LibraryManagementSystem.Repository.AuthorRepository;
import com.example.LibraryManagementSystem.Repository.BookRepository;
import com.example.LibraryManagementSystem.RequestDto.BookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService
{

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    BookRepository bookRepository;

    public String createBook(BookRequestDto bookRequestDto)
    {

        Book book= BookConvertor.convertDtoToEntity(bookRequestDto);

        //getting author id

        int authorId=bookRequestDto.getAuthorId();


        //find author entity

        Author author=authorRepository.findById(authorId).get();

        book.setAuthor(author);

        //booklist also be updated

        List<Book>currentListOfBooks=author.getBooksWritten();
        currentListOfBooks.add(book);
        author.setBooksWritten(currentListOfBooks);

        //save the author
        authorRepository.save(author);


        //save the book
        bookRepository.save(book);

        return "successfully added book";

    }
}
