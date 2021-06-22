package com.devgabriel.dsvendas.services;

import com.devgabriel.dsvendas.dtos.SellerDTO;
import com.devgabriel.dsvendas.entities.Seller;
import com.devgabriel.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

  @Autowired
  private SellerRepository repository;

  @Transactional(readOnly = true)
  public List<SellerDTO> findAll() {
    List<Seller> sellers = repository.findAll();
    return sellers.stream()
            .map(SellerDTO::new)
            .collect(Collectors.toList());
  }
}
