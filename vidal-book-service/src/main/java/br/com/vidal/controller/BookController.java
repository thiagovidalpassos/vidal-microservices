package br.com.vidal.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vidal.model.Book;

@RestController
@RequestMapping("book-service")
public class BookController {
	
	@Autowired
	private Environment environment;
	
	@GetMapping(value = "{id}/{currency]")
	public Book findById(@PathVariable("id") Long id, @PathVariable("currency") String currency) {
		
		var port = environment.getProperty("local.server.port");
		
		return new Book(1L, "Vidal", "Meu livro", new Date(), Double.valueOf(10.5), currency, port);
		
	}

}
