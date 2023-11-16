package com.example.foodselection.repository;

import com.example.foodselection.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionHistory extends JpaRepository<Transaction, Integer>, JpaSpecificationExecutor<Transaction> {

}
