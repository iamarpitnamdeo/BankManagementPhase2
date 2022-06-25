package com.example.BankManagementSystemPhase1.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.BankManagementSystemPhase1.Entity.AccountHolder;
import com.example.BankManagementSystemPhase1.Entity.CustomUserDetails;

public class CustomUserDetailsService implements UserDetailsService {

	@Autowired 
	private AccountHolderRepository accountHolderService;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		AccountHolder accHolder = accountHolderService.findByEmail(email);
		if(accHolder==null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetails(accHolder);
	}

}
