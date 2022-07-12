package com.minibanking.rest.webservices.resfulwebservices.minibanking;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Transaction {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "id")
	private Long id;
	 @Column(name = "username")
	private String username;
	 @Column(name = "remark")
	private String remark;
	 @Column(name = "transaction_date")
	private Date transactionDate;
	 @Column(name = "transaction_type")
	private String transactionType;
	 @Column(name = "amount")
	private Double amount;
	
	protected Transaction() {
		
	}
	
	public Transaction(Long id, String username, String remark, Date transactionDate, String transactionType,
			Double amount) {
		super();
		this.id = id;
		this.username = username;
		this.remark = remark;
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
		this.amount = amount;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
