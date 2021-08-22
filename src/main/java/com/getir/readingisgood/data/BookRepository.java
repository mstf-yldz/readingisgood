package com.getir.readingisgood.data;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.getir.readingisgood.modal.Book;

public interface BookRepository extends MongoRepository<Book, Long>{
	
	<S extends Book> S save(S book);
	Optional<Book> findById(Long id);
}
