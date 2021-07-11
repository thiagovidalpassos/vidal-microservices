package br.com.vidal.controller;

import java.math.BigDecimal;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vidal.model.Cambio;

@RestController
@RequestMapping("cambio-service")
public class CambioController {
	
	private Environment environment;
	
	//http://localhost:8000/cambio-service/5/USD/BRL
	@GetMapping(value="/{amount}/{from}/{to}")
	public Cambio getCambio(@PathVariable("amount") BigDecimal amount,
			                @PathVariable("from") String from,
			                @PathVariable("to") String to) {
		
		var port = environment.getProperty("local.server.port"); //passa o parametro que quer buscar na variavel
		
		return new Cambio(1L, from, to, BigDecimal.ONE, BigDecimal.ONE, port);
	}

}