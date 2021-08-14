package guru.springframework.controller;

import guru.springframework.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

/**
 * Create By Ankit Mishra on 14th August 2021
 */
@RestController
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping(value = "/books", produces = MediaType.APPLICATION_JSON_VALUE)
    public List getBooks() {
        List books = Collections.singletonList(bookRepository.findAll());
        return books;
    }
}
