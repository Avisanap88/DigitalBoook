package com.digitalbook.repositories;
import com.digitalbook.entities.*;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

	public List<Payment> findByUserUserId(Integer userId);

}