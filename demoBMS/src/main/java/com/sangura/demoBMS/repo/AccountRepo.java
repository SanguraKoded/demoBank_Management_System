package com.sangura.demoBMS.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sangura.demoBMS.entities.Account;

public interface AccountRepo extends JpaRepository<Account, Long>{

}
