package com.devsuperior.hrpayroll.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import com.devsuperior.hrpayroll.feignClients.WorkerFeignClient;

/*como não precisa de banco de dados, não há necessidade de criar um PaymentRepository. Essa classe só vai fazer a regra de negocio*/

/*@Component Registra essa classe como componete do Spring*/
@Service /*mesma coisa que o component*/
public class PaymentService {
	
	
	@Autowired
	private WorkerFeignClient workFeignClient;
	
	
	public Payment getPayment(long workerId, int days) {
		
		Worker worker = workFeignClient.findById(workerId).getBody();
		return new Payment(worker.getName(), worker.getDailyIncome(),days);
		
	}

}
