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
        repository.insert(book);
    }

    @GetMapping(path = "{id}")
    public Book getBook(@PathVariable("id") String id){
        return repository.findById(id).orElse(null);
    }

    @PutMapping(path = "{id}")
    public void updateBook(@PathVariable("id") String id, @RequestBody Book book){
        //repository.
    }

    @DeleteMapping(path = "{id}")
    public void deleteBook(@PathVariable("id") String id){
        repository.delete(repository.findById(id).get());
    }

}
