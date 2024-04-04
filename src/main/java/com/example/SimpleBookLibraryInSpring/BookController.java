package com.example.SimpleBookLibraryInSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public Book getById (@PathVariable("id") int id){
        return bookRepository.getById(id);
    }

    @PostMapping("/books")
    public int add (@RequestBody List<Book> books){
        return bookRepository.saveBook(books);
    }
    @PutMapping ("/{id}")
    public int update (@PathVariable("id") int id,
                       @RequestBody Book updatedBook){
        Book book = bookRepository.getById(id);
        if (book != null){
            book.setTitleBook(updatedBook.getTitleBook());
            book.setNameAuthor(updatedBook.getNameAuthor());
            book.setSurnameAuthor(updatedBook.getSurnameAuthor());
            bookRepository.update(book);
            return 1;
        }else {
            return -1;
        }
    }
    @DeleteMapping("/books/{id}")
    public int deleteBookById ( @PathVariable("id") int id){
        bookRepository.deleteById(id);
        return 1;
    }
}
