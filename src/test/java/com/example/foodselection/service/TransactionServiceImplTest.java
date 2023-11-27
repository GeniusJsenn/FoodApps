package com.example.foodselection.service;

import com.example.foodselection.data.dto.FoodRequest;
import com.example.foodselection.data.dto.FoodResultResponse;
import com.example.foodselection.data.service.TransactionServiceImpl;
import com.example.foodselection.repository.TransactionHistory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {

    @InjectMocks
    private TransactionServiceImpl transactionService;
    @Mock
    private TransactionHistory transactionHistory;

    /**
     * Get random food result.
     */
    @Test
    @DisplayName("Test for Food service")
    void getRandomFoodResult(){
        List<String> foodList = new ArrayList<>();
        foodList.add("KFC");
        foodList.add("MCD");
        foodList.add("TEXAS");
        foodList.add("Hawker");
        foodList.add("Chicken Rice");
        foodList.add("FishBall Mee");
        foodList.add("Western Food");
        foodList.add("Indian Food");
        foodList.add("Malay Food");
        foodList.add("Chinese Food");

        FoodRequest foodRequest = new FoodRequest();
        foodRequest.setFoodList(foodList);

        FoodResultResponse foodResultResponse = transactionService.getFoodResult(foodRequest);

        Assertions.assertTrue(foodList.contains(foodResultResponse.getFoodResult()));
    }


    /**
     * Get empty response result.
     */
    @Test
    @DisplayName("Test for empty food selection in list.")
    void getEmptyResponseResult(){
        FoodRequest foodRequest = new FoodRequest();
        foodRequest.setFoodList(Collections.emptyList());

        FoodResultResponse foodResultResponse = transactionService.getFoodResult(foodRequest);

        Assertions.assertEquals(FoodResultResponse.builder().build(), foodResultResponse);
    }
}
