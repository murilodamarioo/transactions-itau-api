package com.innovation.itau.modules.transactions.controllers;

import com.innovation.itau.modules.transactions.dto.TransactionRequestDTO;
import com.innovation.itau.modules.transactions.usecases.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    private TransactionsService transactionsService;


    @PostMapping("/")
    public ResponseEntity<Void> createTransaction(@RequestBody TransactionRequestDTO requestDTO) {
        this.transactionsService.create(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteTransactions() {
        this.transactionsService.delete();
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
