package com.twinleaves.GtinManager.Repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.twinleaves.GtinManager.Entity.Product;

@Repository
public interface ProductRepositry extends JpaRepository<Product,Long>{
    
}
