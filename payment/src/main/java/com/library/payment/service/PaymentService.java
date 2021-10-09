package com.library.payment.service;

import com.library.payment.dto.PaymentRequestDto;
import com.library.payment.dto.PaymentResponseDto;
import com.library.payment.entity.Payment;
import com.library.payment.repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

  @Autowired
  PaymentRepo paymentRepo;

  public PaymentResponseDto payBill(PaymentRequestDto paymentDto) {
    Payment payment = Payment.builder()
        .amount(paymentDto.getPaymentAmount()).build();
    payment = paymentRepo.save(payment);
    return PaymentResponseDto.builder().paymentAmount(payment.getAmount())
        .paymentId(payment.getId())
        .paymentMode(payment.getPaymentMode())
        .paymentStatus(payment.getPaymentStatus())
        .build();
  }
}
