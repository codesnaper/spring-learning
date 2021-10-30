package com.example.reactivecoffeemongo.modal;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class ProductBO {

    @JsonProperty("Product id")
    private String id;

    @JsonProperty("Rate")
    private Double price;

    @JsonProperty("Product Name")
    private String name;

    @JsonProperty("Product Code")
    private String code;
}
