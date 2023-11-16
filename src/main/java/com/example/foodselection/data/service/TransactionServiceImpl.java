package com.example.foodselection.data.service;

import com.example.foodselection.data.dto.FoodRequest;
import com.example.foodselection.data.dto.FoodResultResponse;
import com.example.foodselection.model.Transaction;
import com.example.foodselection.repository.TransactionHistory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor
@Slf4j
public class TransactionServiceImpl {


    private final TransactionHistory transactionHistory;

    /**
     * Gets food result.
     *
     * @param request the request
     * @return the food result
     */
    public FoodResultResponse getFoodResult(FoodRequest request) {

        Transaction transaction = new Transaction();

        if (!CollectionUtils.isEmpty(request.getFoodList())) {
            Map<Integer, String> foodMap = IntStream.range(0, request.getFoodList().size())
                    .boxed()
                    .collect(Collectors.toMap(
                            index -> index,
                            request.getFoodList()::get
                    ));

            Random random = new Random();
            int generatedRandom = random.nextInt(request.getFoodList().size());
            log.info("Decision : " + foodMap.get(generatedRandom));
            transaction.setTransaction(String.valueOf(generatedRandom));
            transaction.setFoodResult(foodMap.get(generatedRandom));
            transactionHistory.save(transaction);
            return FoodResultResponse.builder().foodResult(foodMap.get(generatedRandom)).build();
        }
        return FoodResultResponse.builder().build();
    }
}
