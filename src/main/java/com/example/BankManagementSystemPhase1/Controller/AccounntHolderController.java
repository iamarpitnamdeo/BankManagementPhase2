package com.example.BankManagementSystemPhase1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.BankManagementSystemPhase1.Entity.AccountHolder;
import com.example.BankManagementSystemPhase1.Repository.AccountHolderService;

@Controller
public class AccounntHolderController {
	
	@Autowired
	AccountHolderService  accountHolderService;
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@PostMapping("/addUser")
	public String createUser(@ModelAttribute("userId")String userId,@ModelAttribute("firstName")String firstName,
			@ModelAttribute("lastName") String lastName,@ModelAttribute("email")String email,
			@ModelAttribute("mobileNo") String mobileNo,@ModelAttribute("address") String address,
			@ModelAttribute("idProof")String idProof,@ModelAttribute("accountType")String accountType){
		AccountHolder accountHolder = new AccountHolder(userId,firstName,lastName,email,Integer.valueOf(mobileNo),address,idProof,accountType);
		AccountHolder saveUser =  accountHolderService.addUser(accountHolder);
		if(saveUser!=null)
		{
			return "login";
		}
		else
		{
			return "fail";
		}
	}
	


	@RequestMapping("/")
	public String check() {
		System.out.println("Check method working");
		return "Check method working";
	}

}
