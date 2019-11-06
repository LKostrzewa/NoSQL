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
    public Book getBook(@PathVariable("id") int id){
        return repository.findById(id).orElse(null);
    }

    @PostMapping(path = "{id}")
    public void updateBook(@PathVariable("id") int id, @RequestBody Book book){
        repository.findById(id).ifPresent(b -> {
            Book tmp = new Book(id, book.getTitle(), book.getAuthors(), book.getAvgRating(),
                    book.getIsbn(), book.getIsbn13(), book.getLanguage(), book.getPages(),
                    book.getCountRating(), book.getCountTextReview());
            repository.delete(b);
            repository.insert(tmp);
        });
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
