package com.synechron.repositories;

import org.springframework.data.repository.CrudRepository;

import com.synechron.entities.Account;

public interface AccountRepository extends CrudRepository<Account, Integer> {

}
