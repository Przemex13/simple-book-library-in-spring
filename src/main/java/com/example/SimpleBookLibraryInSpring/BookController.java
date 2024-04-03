package com.example.SimpleBookLibraryInSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class BookController {
    @Autowired
    BookRepository bookRepository;
    @GetMapping("/przemas")
    public String test (){
        return "Przemo Mistrz";
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return bookRepository.getAll();
    }
}
