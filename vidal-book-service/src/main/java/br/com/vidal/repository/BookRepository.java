package br.com.vidal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vidal.model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}