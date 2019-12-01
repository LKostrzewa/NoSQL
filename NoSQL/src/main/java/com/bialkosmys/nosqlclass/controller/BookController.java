package com.bialkosmys.nosqlclass.controller;


import com.bialkosmys.nosqlclass.model.Book;
import com.bialkosmys.nosqlclass.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    private BookRepository repository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        repository = bookRepository;
    }

    @GetMapping
    public List<Book> getAllBooks(){
        return repository.findAll();
    }

    @PostMapping
    public void addBook(@RequestBody Book book){
        if(repository.findById(book.getId()).isEmpty())
            repository.insert(book);
    }

    @GetMapping(path = "{id}")
    public Book getBook(@PathVariable("id") int id){
        return repository.findById(id).orElse(null);
    }

    @PutMapping
    public void updateBook(@RequestBody Book book){
        if(repository.findById(book.getId()).isPresent())
            repository.insert(book);
    }

    @DeleteMapping(path = "{id}")
    public void deleteBook(@PathVariable("id") int id){
        repository.findById(id).ifPresent(b -> repository.delete(b));
    }

    @DeleteMapping
    public void deleteAllBooks(){
        repository.deleteAll();
    }
}
