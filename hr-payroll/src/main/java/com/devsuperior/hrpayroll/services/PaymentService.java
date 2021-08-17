package com.devsuperior.hrpayroll.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.hrpayroll.entities.Payment;
import com.devsuperior.hrpayroll.entities.Worker;
import com.devsuperior.hrpayroll.feignClients.WorkerFeignClient;

/*como não precisa de banco de dados, não há necessidade de criar um PaymentRepository. Essa classe só vai fazer a regra de negocio*/

/*@Component Registra essa classe como componete do Spring*/
@Service /*mesma coisa que o component*/
public class PaymentService {
	
	static Logger logger = LoggerFactory.getLogger(PaymentService.class);

	@Autowired
	private WorkerFeignClient workFeignClient;

	
	public Payment getPayment(long workerId, int days) {

		Worker worker = workFeignClient.findById(workerId).getBody();
		logger.info("Aqui****************************************** workerid: " + workerId);
		return new Payment(worker.getName(), worker.getDailyIncome(),days);
		
	}

}
