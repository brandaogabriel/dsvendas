package com.devgabriel.dsvendas.controllers;

import com.devgabriel.dsvendas.dtos.SaleDTO;
import com.devgabriel.dsvendas.dtos.SaleSuccessDTO;
import com.devgabriel.dsvendas.dtos.SaleSumDTO;
import com.devgabriel.dsvendas.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/sales")
public class SaleController {

  @Autowired
  private SaleService service;
  
  @GetMapping
  public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
    return ResponseEntity
            .ok()
            .body(service.findAll(pageable));
  }

  @GetMapping(value = "/amount-by-seller")
  public ResponseEntity<List<SaleSumDTO>> amountGroupBySeller() {
    return ResponseEntity
            .ok()
            .body(service.amountGroupBySeller());
  }

  @GetMapping(value = "/success-by-seller")
  public ResponseEntity<List<SaleSuccessDTO>> successGroupBySeller() {
    return ResponseEntity
            .ok()
            .body(service.successGroupBySeller());
  }
}
