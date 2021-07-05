package br.com.vidal.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.vidal.model.Person;

@Service
public class PersonService {
	
	private final AtomicLong counter = new AtomicLong();
	
	public Person findById(String id) {
		
		Person person = new Person();
		person.setId(counter.incrementAndGet()); //simula id do banco de dados
		person.setFirstName("Thiago");
		person.setLastName("Passos");
		person.setGender("M");
		person.setAddress("Curitiba/PR");
		return person;		
	}
	
	public List<Person> findAll() {
		List<Person> people = new ArrayList<Person>();
		for (int i = 0; i < 8; i++ ) {
			Person person = mockPerson(i);
			people.add(person);
			
		}
		return people;
		
	}

	private Person mockPerson(int i) {
		Person person = new Person();
		person.setId(counter.incrementAndGet());
		person.setFirstName("Person Name" + i);
		person.setLastName("Person Last Name" + i);
		person.setGender("Some Gender" + i);
		person.setAddress("Some address" + i);
		return person;		
	}

}
