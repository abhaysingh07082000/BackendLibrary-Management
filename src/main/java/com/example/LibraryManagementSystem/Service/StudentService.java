package com.example.LibraryManagementSystem.Service;


import com.example.LibraryManagementSystem.Enums.CardStatus;
import com.example.LibraryManagementSystem.Models.Card;
import com.example.LibraryManagementSystem.Models.Student;
import com.example.LibraryManagementSystem.Repository.StudentRepository;
import com.example.LibraryManagementSystem.RequestDto.StudentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService
{

    @Autowired
    StudentRepository studentRepository;

    CardService cardService;

    public String createStudent(StudentRequestDto studentRequestDto)
    {


        Student student=new Student();

        student.setAge(studentRequestDto.getAge());

        student.setName(studentRequestDto.getName());

        student.setEmail(studentRequestDto.getEmail());

        student.setCountry(studentRequestDto.getCountry());



         Card newCard= cardService.creatCard(student);



        //for the bidirectional relation

        student.setCard(newCard);

        studentRepository.save(student);

        return "Student created successfully";
    }


}
