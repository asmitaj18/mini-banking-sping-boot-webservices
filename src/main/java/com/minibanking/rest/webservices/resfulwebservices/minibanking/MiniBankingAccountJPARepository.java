package com.minibanking.rest.webservices.resfulwebservices.minibanking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MiniBankingAccountJPARepository extends JpaRepository<Account, Long> {
	Account findAccByUsername(String username);
}
