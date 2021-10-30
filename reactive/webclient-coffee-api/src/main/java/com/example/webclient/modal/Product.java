package com.example.webclient.modal;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Product {

    private String id;

    private String name;

    private Double price;

    private String code;

}
