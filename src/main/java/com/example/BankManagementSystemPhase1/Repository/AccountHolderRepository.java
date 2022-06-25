package com.example.BankManagementSystemPhase1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.BankManagementSystemPhase1.Entity.AccountHolder;


public interface AccountHolderRepository extends JpaRepository<AccountHolder,Long>{
	
	@Query("SELECT u FROM AccountHolder u WHERE u.email = ?1")
	AccountHolder findByEmail(String email);
	
}
