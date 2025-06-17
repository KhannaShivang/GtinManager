package com.twinleaves.GtinManager.Service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twinleaves.GtinManager.Entity.Product;
import com.twinleaves.GtinManager.Repositry.GtinRepository;
import com.twinleaves.GtinManager.Repositry.ProductRepositry;

@Service
public class ProductService {
    @Autowired
    private ProductRepositry productRepositry;
    @Autowired
    private GtinRepository gtinRepository;

    public Product createProduct(Product product){
        product.setCreatedOn(LocalDate.now());
        return productRepositry.save(product);
    }

    public Product getProductByGtin(String gtin){
        return gtinRepository.findByGtin(gtin).orElseThrow(()->new RuntimeException("GTIN not found")).getProduct();
    }
}
