package com.example.BankManagementSystemPhase1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	public String viewHomePage() {
		return "index";
	}
	@GetMapping("/register")
	public String showSignUpForm(Model model)
	{
		model.addAttribute("accHolder", new AccountHolder());
		return "signup_form";
	}
	@PostMapping("/process_register")
	public String processRegistraion(AccountHolder accHolder){
		AccountHolder accountHolder = accHolder;
		AccountHolder saveUser =  accountHolderService.addUser(accountHolder);
		if(saveUser!=null)
		{
			return "register_sucess";
		}
		else
		{
			return "fail";
		}
	}
	
	@GetMapping("/list_users")
	public String viewUsersList() {
		return "users";
	}
	



}
