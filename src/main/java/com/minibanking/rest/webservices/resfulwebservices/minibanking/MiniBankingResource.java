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
public class MiniBankingResource {
	
	@Autowired
	private MiniBankingService miniBankingService;
	
	@GetMapping("/mini-banking/{username}/transactions")
	public List<Transaction> getAllTransaction(@PathVariable String username) {
		return miniBankingService.findAllTrans();
		
	}
	
	@GetMapping("/mini-banking/{username}/account-info")
	public Account getAccountInfo(@PathVariable String username) {
		return miniBankingService.getUserAccountInfo();
		
	}
	
	@PostMapping("/mini-banking/{username}/perform-transaction")
	public ResponseEntity<Account> performTransaction(@PathVariable String username, @RequestBody Transaction transaction ) {
		System.out.println("Check incoming tran obj" + transaction.toString());
		Account updatedAccountInfo =  miniBankingService.performTransactions(transaction);
		//URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("{id}").buildAndExpand(createdTrans.getId()).toUri();
		
		return ResponseEntity.ok(updatedAccountInfo);
		
	}

}
