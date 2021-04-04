package com.management.employee.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.employee.modal.StripePaymentResponse;

public interface StripePaymentRepository extends JpaRepository<StripePaymentResponse, Integer>{

	Optional<List<StripePaymentResponse>> findByManagerIdAndStatusOrderByIdDesc(Long valueOf, boolean b);

	Optional<List<StripePaymentResponse>> findByManagerIdAndSubscriptionIdAndStatusOrderByIdDesc(Long valueOf, Long id,
			boolean b);

}
