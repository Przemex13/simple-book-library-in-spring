package com.example.SimpleBookLibraryInSpring;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private int idBook;
    private String titleBook;
    private String nameAuthor;
    private String surnameAuthor;

}
