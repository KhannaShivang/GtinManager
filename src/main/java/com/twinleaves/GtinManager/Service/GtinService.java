package com.twinleaves.GtinManager.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twinleaves.GtinManager.Entity.Batch;
import com.twinleaves.GtinManager.Entity.Gtin;
import com.twinleaves.GtinManager.Entity.GtinBatchResponse;
import com.twinleaves.GtinManager.Entity.Product;
import com.twinleaves.GtinManager.Repositry.BatchRepository;
import com.twinleaves.GtinManager.Repositry.GtinRepository;
import com.twinleaves.GtinManager.Repositry.ProductRepositry;

@Service
public class GtinService {
    @Autowired
    private GtinRepository gtinRepositry;
    @Autowired
    private ProductRepositry productRepositry;
    @Autowired
    private BatchRepository batchRepository;
    public Gtin createGtin(Gtin gtin){
        Long productId=gtin.getProduct().getProductId();
        Product product = productRepositry.findById(productId).orElseThrow(()->new RuntimeException("No product found with id :"+productId));
        gtin.setProduct(product);
        return gtinRepositry.save(gtin);
    }

    public List<GtinBatchResponse> getFilteredBatches(){
        List<String>gtins=gtinRepositry.findAllGtinCode();
        List<GtinBatchResponse>result=new ArrayList<>();
        for(String gtin:gtins){
            List<Batch>batches=batchRepository.findByGtin_Gtin(gtin);
            List<Batch>validBatchs=batches.stream().filter((b)->b.getAvailableQuantity()>0).collect(Collectors.toList());
            Optional<Batch> latestNeg=batches.stream().filter((b)->b.getAvailableQuantity()<=0).max(Comparator.comparing(Batch::getInwardedOn));
            if(latestNeg.isPresent()){
                validBatchs.add(latestNeg.get());
            }
            if(!validBatchs.isEmpty()){
                result.add(new GtinBatchResponse(gtin, validBatchs));
            }
        }
        return result;
    }
    
}
