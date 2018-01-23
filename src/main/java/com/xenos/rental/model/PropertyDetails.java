package com.xenos.rental.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyDetails {

    private Integer amountOfTenants;
    private Double monthlyRate;
    private Map<String, Double> expenses;

}
