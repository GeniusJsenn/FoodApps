package com.example.foodselection.controller;

import com.example.foodselection.constant.UriConstant;
import com.example.foodselection.data.dto.FoodRequest;
import com.example.foodselection.data.dto.FoodResultResponse;
import com.example.foodselection.data.service.TransactionServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
@Slf4j
public class FoodController {

    private TransactionServiceImpl transactionService;

    @PostMapping(
            value = {UriConstant.SELECTION},
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<FoodResultResponse> getFoodResult(@RequestBody FoodRequest request) {
        return new ResponseEntity<>(transactionService.getFoodResult(request), HttpStatus.OK);
    }

}
