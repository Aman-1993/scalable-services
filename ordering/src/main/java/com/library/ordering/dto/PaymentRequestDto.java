package com.library.ordering.dto;

import com.library.ordering.enums.PaymentMode;
import com.sun.istack.NotNull;
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
public class PaymentRequestDto {

  private PaymentMode paymentMode = PaymentMode.CASH;

  private String payerName;

  @NotNull
  private Double paymentAmount;
}
