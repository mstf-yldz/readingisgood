package com.getir.readingisgood.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.getir.readingisgood.modal.Publisher;

public interface PublisherRepository extends MongoRepository<Publisher, Long>{

	<S extends Publisher> S save(S publisher);
}
