package com.library.payment.controller;

import com.library.payment.contants.AppConstants;
import com.library.payment.dto.PaymentRequestDto;
import com.library.payment.dto.PaymentResponseDto;
import com.library.payment.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

  @Autowired
  PaymentService paymentService;

  @PostMapping(AppConstants.PAYMENTS)
  public ResponseEntity<PaymentResponseDto> payBill(@RequestBody PaymentRequestDto paymentDto) {
    PaymentResponseDto response = paymentService.payBill(paymentDto);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}