package br.com.vidal.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("vidal-greeting-service") //apontamento para o arquivo yaml
public class GreetingConfiguration {
	
	private String greeting;
	private String defaultValue; //faz o bind mesmo com o nome da variavel diferente
	
	public GreetingConfiguration () {
		
	}

	public String getGreeting() {
		return greeting;
	}

	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

}
