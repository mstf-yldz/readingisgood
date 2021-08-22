package com.getir.readingisgood.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.getir.readingisgood.data.AuthorRepository;
import com.getir.readingisgood.modal.Author;

@Service
public class AuthorServiceImpl implements IAuthorService{

	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private SequenceGeneratorService sequenceGeneratorService;
	
	public Author addAuthor(Author author) {
		author.setId(sequenceGeneratorService.generateSequence(Author.SEQUENCE_NAME));
		return authorRepository.save(author);
	}

}
