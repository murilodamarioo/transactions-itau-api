package com.innovation.itau.modules.transactions.dto;

import java.time.OffsetDateTime;

public record TransactionRequestDTO(Double value, OffsetDateTime dateTime) {
}
