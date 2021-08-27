package com.example.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

	List<Cart> findBytransactionid(String transactionid);

	//List<Cart> findBytransaction_idLike(String transaction_id);
}