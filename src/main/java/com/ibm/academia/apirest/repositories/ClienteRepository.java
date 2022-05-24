package com.ibm.academia.apirest.repositories;

import com.ibm.academia.apirest.entities.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Integer> {
}
