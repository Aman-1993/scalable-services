package com.library.payment.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
  private int quantity;
  private Double price;
  private String name;
  private String description;
}
