package com.example.reactivecoffeemongo.helper;

import com.example.reactivecoffeemongo.entity.Product;
import com.example.reactivecoffeemongo.modal.ProductBO;

public class ProductMapper {

    public static ProductBO productMapper(Product product){
        ProductBO productBO = new ProductBO();
        productBO.setId(product.getId());
        productBO.setName(product.getName());
        productBO.setCode(product.getCode());
        productBO.setPrice(product.getPrice());
        return productBO;
    }

    public static Product getProductEntity(ProductBO productBO){
        Product product = new Product();
        product.setId(productBO.getId());
        product.setName(productBO.getName());
        product.setCode(productBO.getCode());
        product.setPrice(productBO.getPrice());
        return product;
    }
}
