package com.library.payment.dto;

import com.library.payment.enums.PaymentMode;
import com.library.payment.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentResponseDto {
  private PaymentStatus paymentStatus;
  private PaymentMode paymentMode;
  private Long paymentId;
  private Double paymentAmount;
}
