package com.library.ordering.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderResponseDto {
  private Long id;
  private Long itemId;
  private Double amount;
  private Date createdAt;
  private Date lastUpdatedAt;
}
