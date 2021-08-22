package com.getir.readingisgood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getir.readingisgood.data.PublisherRepository;
import com.getir.readingisgood.modal.Publisher;

@Service
public class PublisherServiceImpl implements IPublisherService{

	@Autowired
	private PublisherRepository publisherRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	public Publisher addPublisher(Publisher publisher) {
		publisher.setId(sequenceGeneratorService.generateSequence(Publisher.SEQUENCE_NAME));
		return publisherRepository.save(publisher);
	}

}
