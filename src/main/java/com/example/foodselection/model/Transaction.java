package com.example.foodselection.model;

import com.example.foodselection.constant.FoodConstant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The type Transaction.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = FoodConstant.TBL_TRANSACTION_HISTORY)

public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = FoodConstant.TRANSACTION, nullable = false)
    private String transaction;

    @Column(name = FoodConstant.FOOD_RESULT, nullable = false)
    private String foodResult;
}
