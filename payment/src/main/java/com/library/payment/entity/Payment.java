package com.library.payment.entity;

import com.library.payment.enums.PaymentMode;
import com.library.payment.enums.PaymentStatus;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  private PaymentMode paymentMode;

  @Enumerated(EnumType.STRING)
  private PaymentStatus paymentStatus=PaymentStatus.SUCCESS;

  private String description;

  private Double amount;
}
