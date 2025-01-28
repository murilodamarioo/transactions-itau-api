package com.innovation.itau.modules.transactions.usecases;

import com.innovation.itau.infrastructure.UnprocessableEntity;
import com.innovation.itau.modules.transactions.dto.TransactionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionsService {

    private final List<TransactionRequestDTO> transactions = new ArrayList<>();

    public void create(TransactionRequestDTO requestDTO) {
        if (requestDTO.dateTime().isAfter(OffsetDateTime.now())) {
            throw new UnprocessableEntity("Date and time greater than the current date");
        }

        if (requestDTO.value() < 0) {
            throw new UnprocessableEntity("The value of transaction can not be less than zero");
        }

        transactions.add(requestDTO);
    }

    public void delete() {
        transactions.clear();
    }
}
