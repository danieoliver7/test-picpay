package com.picpay.picpaytest.repositories;

import com.picpay.picpaytest.domain.transaction.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrasactionRepository extends JpaRepository<Transaction,Long> {
}
