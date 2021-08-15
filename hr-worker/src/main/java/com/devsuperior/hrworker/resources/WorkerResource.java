package com.devsuperior.hrworker.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.hrworker.entities.Worker;
import com.devsuperior.hrworker.repositories.WorkerRepository;
/*classe que serve como Web Service, recursos que disponibilizará os ends-points*/
@RestController
@RequestMapping(value="/workers")
public class WorkerResource {

	@Autowired /*injeção de dependencias usando o framework*/
	private WorkerRepository repository; /*objeto q acessa o banco de dados*/
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		List<Worker> list = repository.findAll();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/{id}")/*Para o id ser passado por parametro e ser pego pelo GetMapping é necessario colocar o @PathVariable*/
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		Worker obj = repository.findById(id).get();
		return ResponseEntity.ok(obj);
	}
}
