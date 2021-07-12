package br.com.vidal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vidal.model.Cambio;

public interface CambioRepository extends JpaRepository<Cambio, Long>{
	
	Cambio findByFromAndTo(String from, String to);

}
