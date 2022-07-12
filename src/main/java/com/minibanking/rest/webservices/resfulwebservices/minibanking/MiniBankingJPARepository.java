package com.minibanking.rest.webservices.resfulwebservices.minibanking;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiniBankingJPARepository extends JpaRepository<Transaction, Long> {
	List<Transaction> findByUsername (String username);

}
