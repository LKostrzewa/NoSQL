package com.bialkosmys.nosqlclass.model;


import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @PrimaryKey
    private int id;
    private String title;
    private String authors;
    private float avgRating;
    private String isbn;
    private String isbn13;
    private String language;
    private int pages;
    private int countRating;
    private int countTextReview;
}
