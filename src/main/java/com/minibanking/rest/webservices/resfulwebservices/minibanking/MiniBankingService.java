package com.minibanking.rest.webservices.resfulwebservices.minibanking;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;

@Service
public class MiniBankingService {
	
	private static List<Transaction> transactions = new ArrayList<>();
	private static Account accountInfo = new Account((long)100001, "XXXXXXXX8909", (double)14000, "asmitaj");
	private static long idCounter = 0;
	
	static {
		transactions.add(new Transaction(++idCounter, "asmitaj", "Trans 1", new Date(), "Cr.", (double) 1400));
		transactions.add(new Transaction(++idCounter, "asmitaj", "Trans 2", new Date(), "Cr.", (double) 1500));
		transactions.add(new Transaction(++idCounter, "asmitaj", "Trans 3", new Date(), "Db.", (double) 1600));
		transactions.add(new Transaction(++idCounter, "asmitaj", "Trans 4", new Date(), "Cr.", (double) 1700));
	}
	
	public List<Transaction> findAllTrans() {
		return transactions;
	}

	public Account getUserAccountInfo() {
		return accountInfo;
	}
	
	public Account performTransactions(Transaction transaction) {
		Transaction newTransRec = new Transaction(++idCounter, "asmitaj", transaction.getRemark(), new Date(), transaction.getTransactionType(), transaction.getAmount());
		transactions.add(newTransRec);
		if(transaction.getTransactionType().equals("Cr.")) {
			performFundDeposit((double)transaction.getAmount());
		} else {
			performFundWithdrawal((double)transaction.getAmount());
		}
		System.out.println("Sizeeee" + transactions.size());
		return accountInfo;
	}

	public Account performFundDeposit(Double depositAmt) {
		double currentAccBal = accountInfo.getAccountBalance();
		double updatedAccBal = currentAccBal + depositAmt;
		accountInfo.setAccountBalance(updatedAccBal);
		return accountInfo;
	}

	public Account performFundWithdrawal(Double withdrawalAmt) {
		double currentAccBal = accountInfo.getAccountBalance();
		double updatedAccBal = currentAccBal - withdrawalAmt;
		accountInfo.setAccountBalance(updatedAccBal);
		return accountInfo;
	}

}
