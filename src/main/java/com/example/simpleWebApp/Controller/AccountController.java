package com.example.simpleWebApp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simpleWebApp.Model.Account;
import com.example.simpleWebApp.Service.AccountService;

@RestController
public class AccountController {
	
	@Autowired //it will create the objects
	AccountService service;
	
	@GetMapping("/accounts")
	public List<Account> getAccount() {
		//return the list of products
		return service.getAccount();
	}
	@GetMapping("/accounts/{accountId}")
	public Account getAccountByID(@PathVariable int accountId) {
		return service.getAccountById(accountId);
	}//@PathVariable used to match the prodId 

	@PostMapping("/accounts")
	public void addAccount(Account account) {
		service.addAccount(account);
	}
	
}
