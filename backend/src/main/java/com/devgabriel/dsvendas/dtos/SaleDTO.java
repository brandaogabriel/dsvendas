package com.devgabriel.dsvendas.dtos;

import com.devgabriel.dsvendas.entities.Sale;

import java.io.Serializable;
import java.time.LocalDate;

public class SaleDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;
  private Integer visited;
  private Integer deals;
  private Double amount;
  private LocalDate date;
  private long sellerId;

  private SellerDTO sellerDTO;

  public SaleDTO() {
  }

  public SaleDTO(Sale entity) {
    id = entity.getId();
    visited = entity.getVisited();
    deals = entity.getDeals();
    amount = entity.getAmount();
    date = entity.getDate();
    sellerId = entity.getSeller().getId();
    sellerDTO = new SellerDTO(entity.getSeller());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Integer getVisited() {
    return visited;
  }

  public void setVisited(Integer visited) {
    this.visited = visited;
  }

  public Integer getDeals() {
    return deals;
  }

  public void setDeals(Integer deals) {
    this.deals = deals;
  }

  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public long getSellerId() {
    return sellerId;
  }

  public void setSellerId(long sellerId) {
    this.sellerId = sellerId;
  }
}
