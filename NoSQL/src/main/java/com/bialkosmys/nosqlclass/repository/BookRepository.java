package com.bialkosmys.nosqlclass.repository;

import com.bialkosmys.nosqlclass.model.Book;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CassandraRepository<Book, Integer> {
}
