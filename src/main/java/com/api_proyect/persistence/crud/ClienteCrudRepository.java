package com.api_proyect.persistence.crud;

import com.api_proyect.persistence.entity.Cliente;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClienteCrudRepository extends CrudRepository<Cliente,Integer> {

}
