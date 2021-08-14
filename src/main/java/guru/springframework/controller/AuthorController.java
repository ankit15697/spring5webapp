package guru.springframework.controller;

import guru.springframework.domain.Author;
import guru.springframework.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Create By Ankit Mishra on 14th August 2021
 */
@RestController
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping(value = "/authors")
    public List getAuthors() {
        List books = Collections.singletonList(authorRepository.findAll());
        return books;
    }
    @GetMapping(value = "/author/{id}")
    public Optional<Author> getAuthorById(@PathVariable Long id) {
       return authorRepository.findById(id);
    }
}
