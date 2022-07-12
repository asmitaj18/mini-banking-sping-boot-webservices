package com.minibanking.rest.webservices.resfulwebservices.minibanking;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "id")
	private Long id;
	 @Column(name = "account_no")
	private String accountNo;
	 @Column(name = "account_balance")
	private Double accountBalance;
	@Column(name = "username")
		private String username;
	
	protected Account() {
		
	}
	
	public Account(Long id, String accountNo, Double accountBalance, String username) {
		super();
		this.id = id;
		this.accountNo = accountNo;
		this.accountBalance = accountBalance;
		this.username = username;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	public String getAccountNo() {
		return accountNo;
	}
	
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	
	public Double getAccountBalance() {
		return accountBalance;
	}
	
	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}
}
