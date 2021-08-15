package com.devsuperior.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;

/*como não precisa de banco de dados, não há necessidade de criar um PaymentRepository. Essa classe só vai fazer a regra de negocio*/

/*@Component Registra essa classe como componete do Spring*/
@Service /*mesma coisa que o component*/
public class PaymentService {
	
	
	@Value("${hr-worker.host}")/*pega do application.properties*/
	private String workerHost;
	@Autowired
	private RestTemplate restTemplate;
	
	public Payment getPayment(long workerId, int days) {
		Map<String,String> uriVariables = new HashMap<>();
		uriVariables.put("id", ""+workerId); 
		
		
		Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, uriVariables );
		return new Payment(worker.getName(), worker.getDailyIncome(),days);
	}

}
