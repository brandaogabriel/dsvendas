package com.devgabriel.dsvendas.dtos;

import com.devgabriel.dsvendas.entities.Seller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SellerDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;
  private String name;
  private final List<SaleDTO> salesDTO = new ArrayList<>();

  public SellerDTO() {
  }

  public SellerDTO(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public SellerDTO(Seller entity) {
    id = entity.getId();
    name = entity.getName();
    entity.getSales().forEach(x -> salesDTO.add(new SaleDTO(x)));
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<SaleDTO> getSalesDTO() {
    return salesDTO;
  }
}
