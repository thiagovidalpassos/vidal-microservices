package br.com.vidal.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.vidal.model.Cambio;
import br.com.vidal.repository.CambioRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Cambio Endpoint") //tag para o endpoint Swagger
@RestController
@RequestMapping("cambio-service")
public class CambioController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private CambioRepository repository;
	
	@Operation(summary = "Run cambio") //descrição para endpoint Swagger
	@GetMapping(value="/{amount}/{from}/{to}")
	public Cambio getCambio(@PathVariable("amount") BigDecimal amount,
			                @PathVariable("from") String from,
			                @PathVariable("to") String to) {
		
		var cambio = repository.findByFromAndTo(from, to);
		if (cambio == null) throw new RuntimeException("CUrrency Unsupported");
		
		var port = environment.getProperty("local.server.port"); //passa o parametro que quer buscar na variavel
		BigDecimal conversionFactor = cambio.getConversionFactor();
		BigDecimal convertedValue = conversionFactor.multiply(amount);
		cambio.setConvertedValue(convertedValue.setScale(2, RoundingMode.CEILING)); //arredondamento
		cambio.setEnvironment(port);
		return cambio;
	}

}