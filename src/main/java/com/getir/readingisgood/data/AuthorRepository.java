package com.getir.readingisgood.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.getir.readingisgood.modal.Author;

public interface AuthorRepository extends MongoRepository<Author, Long>{

	<S extends Author> S save(S author);
}
