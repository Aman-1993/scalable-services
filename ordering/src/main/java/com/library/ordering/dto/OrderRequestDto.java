package com.library.ordering.dto;

import com.sun.istack.NotNull;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderRequestDto {

  @NotNull
  private Double totalAmount;

  @NotNull
  private String payerName;

  @NotNull
  private Long itemId;

  private Long paymentId;

}
