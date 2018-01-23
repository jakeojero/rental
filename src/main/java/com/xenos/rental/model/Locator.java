package com.xenos.rental.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Locator {

    private String address;
    private String postalCode;
    private String city;
    private String province;
    private String country;

}
