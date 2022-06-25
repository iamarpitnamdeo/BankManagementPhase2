package com.example.BankManagementSystemPhase1.Repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BankManagementSystemPhase1.Entity.AccountHolder;

@Service
public class AccountHolderService {

	@Autowired
	AccountHolderRepository aAccountHolderRepository;
	
	public AccountHolder addUser(AccountHolder accountHolder)
	{
		return aAccountHolderRepository.save(accountHolder);
	}
	
	public AccountHolder findByEmail(String email)
	{
		return aAccountHolderRepository.findByEmail(email);
	}
}
