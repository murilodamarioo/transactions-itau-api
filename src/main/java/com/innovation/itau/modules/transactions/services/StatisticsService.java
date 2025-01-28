package com.innovation.itau.modules.transactions.services;

import com.innovation.itau.modules.transactions.dto.StatisticsResponseDTO;
import com.innovation.itau.modules.transactions.dto.TransactionRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.DoubleSummaryStatistics;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StatisticsService {

    @Autowired
    private TransactionsService transactionsService;

    public StatisticsResponseDTO calculateStatistics(Integer interval) {
        List<TransactionRequestDTO> transactions = transactionsService.getTransactions(interval);

        if (transactions.isEmpty()) {
            return new StatisticsResponseDTO(0L, 0.0, 0.0, 0.0, 0.0);
        }

        DoubleSummaryStatistics statistics = transactions.stream()
                .mapToDouble(TransactionRequestDTO::value).summaryStatistics();

        return new StatisticsResponseDTO(
                statistics.getCount(),
                statistics.getSum(),
                statistics.getAverage(),
                statistics.getMin(),
                statistics.getMax()
        );
    }
}
