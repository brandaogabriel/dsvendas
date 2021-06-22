package com.devgabriel.dsvendas.services;

import com.devgabriel.dsvendas.dtos.SaleDTO;
import com.devgabriel.dsvendas.dtos.SaleSuccessDTO;
import com.devgabriel.dsvendas.dtos.SaleSumDTO;
import com.devgabriel.dsvendas.entities.Sale;
import com.devgabriel.dsvendas.repositories.SaleRepository;
import com.devgabriel.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class SaleService {

  @Autowired
  private SaleRepository repository;

  @Autowired
  private SellerRepository sellerRepository;

  @Transactional(readOnly = true)
  public Page<SaleDTO> findAll(Pageable pageable) {
    sellerRepository.findAll();
    Page<Sale> result = repository.findAll(pageable);
    return result.map(SaleDTO::new);
  }

  @Transactional(readOnly = true)
  public List<SaleSumDTO> amountGroupBySeller() {
    return repository.amountGroupedBySeller();
  }

  @Transactional(readOnly = true)
  public List<SaleSuccessDTO> successGroupBySeller() {
    return repository.successGroupedBySeller();
  }
}
