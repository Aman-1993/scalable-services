package com.library.payment.dto;

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
public class OrderDto {

  @NotNull
  private Double totalAmount;

  private List<ItemDto> itemDtos;

}
