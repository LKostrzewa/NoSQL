package com.bialkosmys.nosqlclass.repository;

import com.bialkosmys.nosqlclass.model.Book;
import org.springframework.data.cassandra.repository.CassandraRepository;

public interface BookRepository extends CassandraRepository<Book, String> {
}
