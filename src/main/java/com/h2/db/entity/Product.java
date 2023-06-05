package com.h2.db.entity;

import jakarta.persistence.*;
import java.util.Set;
import lombok.*;

@Data
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;
  private String category;
  @With private Double price;

  @ManyToMany(mappedBy = "products")
  @ToString.Exclude
  private Set<Order1> orders;
}
