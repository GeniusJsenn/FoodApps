package com.example.foodselection.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * The type Food request.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodRequest implements Serializable {

    private List<String> foodList;
}
