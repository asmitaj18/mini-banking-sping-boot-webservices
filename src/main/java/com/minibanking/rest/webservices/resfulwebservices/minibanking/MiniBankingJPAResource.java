package com.minibanking.rest.webservices.resfulwebservices.minibanking;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins="http://localhost:4200/")
public class MiniBankingJPAResource {
	
	@Autowired
	private MiniBankingService miniBankingService;
	
	@Autowired
	private MiniBankingJPARepository miniBankingJpaRepo;
	
	@Autowired
	private MiniBankingAccountJPARepository miniBankingAccJpaRepo;
	
	@GetMapping("/jpa/mini-banking/{username}/transactions")
	public List<Transaction> getAllTransaction(@PathVariable String username) {
		return miniBankingJpaRepo.findByUsername(username);
		
	}
	
	@GetMapping("/jpa/mini-banking/{username}/account-info")
	public Account getAccountInfo(@PathVariable String username) {
		return miniBankingAccJpaRepo.findAccByUsername(username);
		
	}
	
	@PostMapping("/jpa/mini-banking/{username}/perform-transaction")
	public ResponseEntity<Account> performTransaction(@PathVariable String username, @RequestBody Transaction transaction ) {
		transaction.setUsername(username);
		miniBankingJpaRepo.save(transaction);
		Account accountObj = miniBankingAccJpaRepo.findAccByUsername(username);
		Double accountBal = accountObj.getAccountBalance();
		if(transaction.getTransactionType().equals("Cr.")) {
			accountObj.setAccountBalance(accountBal + transaction.getAmount());
		}
		if(transaction.getTransactionType().equals("Db.")) {
			accountObj.setAccountBalance(accountBal - transaction.getAmount());
		}
		Account updatedAccountInfo = miniBankingAccJpaRepo.save(accountObj);
		
		//URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("{id}").buildAndExpand(createdTrans.getId()).toUri();
		
		return ResponseEntity.ok(updatedAccountInfo);
		
	}

}
