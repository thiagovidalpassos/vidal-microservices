package br.com.vidal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vidal.model.Book;
import br.com.vidal.repository.BookRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Book Endpoint") //tag para o endpoint Swagger
@RestController
@RequestMapping("book-service")
public class BookController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private BookRepository repository;
	
	@Operation(summary = "Finds book by id") //descrição para endpoint Swagger
	@GetMapping(value = "{id}/{currency]")
	public Book findById(@PathVariable("id") Long id, @PathVariable("currency") String currency) {
		
		
		var book = repository.getById(id);
		if (book == null) throw new RuntimeException("Book not found!");
		
		var port = environment.getProperty("local.server.port");
		book.setEnvironment(port);
		
		return new Book();
		
	}

}
