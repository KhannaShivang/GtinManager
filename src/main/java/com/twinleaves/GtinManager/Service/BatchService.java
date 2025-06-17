package com.twinleaves.GtinManager.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twinleaves.GtinManager.Entity.Batch;
import com.twinleaves.GtinManager.Entity.Gtin;
import com.twinleaves.GtinManager.Repositry.BatchRepository;
import com.twinleaves.GtinManager.Repositry.GtinRepository;

@Service
public class BatchService {
    @Autowired
    private BatchRepository batchRepositry;
    @Autowired
    private GtinRepository gtinRepositry;

    public Batch saveBatch(Batch batch){
        long gtinId = batch.getGtin().getId();
        Gtin gtin = gtinRepositry.findById(gtinId).orElseThrow(()->new RuntimeException("No gtin found with id :"+gtinId));
        batch.setGtin(gtin);
        return batchRepositry.save(batch);
    }
    public List<Batch> findbatchByGtin(String gtin){
        return batchRepositry.findByGtin_Gtin(gtin);
    }

}
