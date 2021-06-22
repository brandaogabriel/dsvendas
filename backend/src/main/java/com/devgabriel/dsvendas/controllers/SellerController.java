package com.devgabriel.dsvendas.controllers;

import com.devgabriel.dsvendas.dtos.SellerDTO;
import com.devgabriel.dsvendas.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

  @Autowired
  private SellerService service;
  
  @GetMapping
  public ResponseEntity<List<SellerDTO>> findAll() {
    return ResponseEntity
            .ok()
            .body(service.findAll());
  }
}
