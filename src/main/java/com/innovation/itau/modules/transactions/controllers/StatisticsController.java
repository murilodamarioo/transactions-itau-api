package com.innovation.itau.modules.transactions.controllers;

import com.innovation.itau.modules.transactions.services.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/")
    public ResponseEntity<Object> get(@RequestParam(value = "interval", required = false, defaultValue = "60") Integer interval) {
        var response = this.statisticsService.calculateStatistics(interval);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
