package com.example.BankManagementSystemPhase1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.BankManagementSystemPhase1.Entity.AccountHolder;


public interface AccountHolderRepository extends JpaRepository<AccountHolder,Long>{
	
}
