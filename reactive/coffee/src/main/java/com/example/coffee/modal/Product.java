package com.example.coffee.modal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.lang.NonNull;

@Data
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Table("product_coffee")
public class Product {

    @Id
    private int id;

    @Column("name")
    private String name;

    @Column(value = "amount")
    private float price;

    @Column
    private int quantity;

}
