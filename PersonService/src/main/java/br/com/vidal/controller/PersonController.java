package br.com.vidal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.vidal.model.Person;
import br.com.vidal.services.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	
    @Autowired
    private PersonService services; //com a notation o proprio spring cria a parte "= new PersonServices()	
	
	@RequestMapping(method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Person> findAll() {
		return services.findAll();	
	}
    
    @RequestMapping(value="/{id}/", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public Person findById(@PathVariable("id") String id) {
		return services.findById(id);	
	}
	
}