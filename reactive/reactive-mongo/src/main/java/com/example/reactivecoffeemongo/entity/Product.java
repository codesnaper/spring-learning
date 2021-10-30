package com.example.reactivecoffeemongo.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@NoArgsConstructor
public class Product {

    @Id
    private String id;

    private String name;

    private Double price;

    private String code;


}
