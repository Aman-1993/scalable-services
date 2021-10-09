package com.library.payment.dto;

import com.library.payment.enums.PaymentMode;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentRequestDto {
  private PaymentMode paymentMode = PaymentMode.CASH;

  @NotNull
  private Double paymentAmount;
}
