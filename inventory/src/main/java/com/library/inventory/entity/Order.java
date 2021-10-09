package com.library.inventory.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Order {

  @Id
  private Long id;

  private String name;

  private String description;

  private Double amount;
}
