package com.devsuperior.hrpayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/*Classe para configurações, vai instanciar um obj para poder usar a API rest do spring*/

@Configuration
public class AppConfig {
	
	/*instancia unica(Singleton) para poder ser injetada em outros componentes*/
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
		
	}

}
