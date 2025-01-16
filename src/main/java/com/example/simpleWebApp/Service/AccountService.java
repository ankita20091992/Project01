package com.example.simpleWebApp.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.simpleWebApp.Model.Account;

@Service
public class AccountService {
	
	List<Account> accounts = new ArrayList<>(Arrays.asList(
			new Account(101, "Ram", "ram07@x.com", "0702" ),
			new Account(102, "Shyam","shyam02@x.com", "0803"),
			new Account(103, "Sita", "sita77@z.com", "0589")
			));
	
	public List<Account> getAccount() {
		return accounts;
	}

	public Account getAccountById(int accountId) {
//stream of accounts via filter-if the account match with account id
		//findFirst : have unique ID
		return accounts.stream()
						.filter(a -> a.getAccountId() == accountId)
						.findFirst().orElse(new Account(100, "No item", "no mail", "0"));
		//.filter(Predicate<?super Product>predicate)
	}

	public void addAccount(Account acc) {
		accounts.add(acc);
	}

	public void updateAccount(Account account) {
		int index=0;
		for(int i=0;i<accounts.size();i++)
			if(accounts.get(i).getAccountId()==account.getAccountId())
				index = i;
		
		accounts.set(index, account);
		
	}

	public void deleteAccount(int accountId) {
		int index=0;
		for(int i=0;i<accounts.size();i++)
			if(accounts.get(i).getAccountId()==accountId)
				index = i;
		
		accounts.remove(index);
		
	}
}
