package com.innovation.itau.modules.transactions.controllers;

import com.innovation.itau.modules.transactions.dto.TransactionRequestDTO;
import com.innovation.itau.modules.transactions.usecases.CreateTransactionUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("transaction")
public class TransactionController {

    @Autowired
    private CreateTransactionUseCase createTransactionUseCase;

    @PostMapping("/")
    public ResponseEntity<Void> createTransaction(@RequestBody TransactionRequestDTO requestDTO) {
        this.createTransactionUseCase.execute(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
