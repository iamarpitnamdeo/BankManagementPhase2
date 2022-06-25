package com.example.BankManagementSystemPhase1;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.example.BankManagementSystemPhase1.Entity.AccountHolder;
import com.example.BankManagementSystemPhase1.Repository.AccountHolderRepository;
import com.example.BankManagementSystemPhase1.Repository.AccountHolderService;

@DataJpaTest
public class AccountHolderRepositoryTest {
	@Autowired
	private AccountHolderRepository repo;
	
	@Autowired
	private AccountHolderService reposervice;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		AccountHolder accountHolder = new AccountHolder();
		accountHolder.setEmail("narpit2@gmail.com");
		accountHolder.setAddress("INDIA");
		accountHolder.setFirstName("Arpit");
		accountHolder.setLastName("Namdeo");
		accountHolder.setIdProof("ABC123");
		accountHolder.setMobileNo(1234567890);
		accountHolder.setPassword("arpit1234");
		AccountHolder saveduser = repo.save(accountHolder);
		
		AccountHolder existuser = entityManager.find(AccountHolder.class, saveduser.getId());
		
		assertThat(existuser.getEmail()).isEqualTo(accountHolder.getEmail());
	}
	@Test
	public void testFindUserByEmail() {
		String email = "narpit2@gmail.com";
		AccountHolder accholder = repo.findByEmail(email);
		
		assertThat(accholder).isNotNull();
	}
	
}
