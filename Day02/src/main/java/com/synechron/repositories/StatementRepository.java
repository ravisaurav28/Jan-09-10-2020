package com.synechron.repositories;

import org.springframework.data.repository.CrudRepository;

import com.synechron.entities.Statement;

public interface StatementRepository extends CrudRepository<Statement, Integer> {

}
