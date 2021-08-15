package com.devsuperior.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.hrworker.entities.Worker;
/*classe q faz o acesso ao banco de dados. Buscar, salvar e entre outros*/
public interface WorkerRepository extends JpaRepository<Worker,Long>{

}
