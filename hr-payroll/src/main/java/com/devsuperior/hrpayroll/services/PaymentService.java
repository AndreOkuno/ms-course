package com.devsuperior.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.devsuperior.hrpayroll.entities.Payment;

/*como não precisa de banco de dados, não há necessidade de criar um PaymentRepository. Essa classe só vai fazer a regra de negocio*/

/*@Component Registra essa classe como componete do Spring*/
@Service /*mesma coisa que o component*/
public class PaymentService {
	
	public Payment getPayment(long workerId, int days) {
		return new Payment("Bob",200.0,days);
	}

}
