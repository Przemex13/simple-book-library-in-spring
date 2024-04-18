package com.example.SimpleBookLibraryInSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class BookRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<Book> getAll(){
        return jdbcTemplate.query("SELECT * FROM book;",
                BeanPropertyRowMapper.newInstance(Book.class));
    }
    public Book getById(int id ){
        return jdbcTemplate.queryForObject("SELECT * FROM book where id = ?",
                BeanPropertyRowMapper.newInstance(Book.class),
                id);
    }
    public int saveBook (List<Book> books){
        books.forEach(book -> jdbcTemplate.update("INSERT INTO book (titleBook, nameAuthor, surnameAuthor)" +
                "VALUES (?,?,?)",
                book.getTitleBook(), book.getNameAuthor(), book.getSurnameAuthor()));
        return 1;
    }

    public int update (Book book){
        jdbcTemplate.update("UPDATE book SET titleBook = ?, nameAuthor = ?, surnameAuthor = ?, WHERE idBook = ?",
                book.getTitleBook(), book.getNameAuthor(), book.getSurnameAuthor(), book.getIdBook());

        return 1;
    }

    public int deleteById (int id){
        jdbcTemplate.update("DELETE FROM book where idBook = ?;",String.valueOf(id));

        return 1;
    }
}
