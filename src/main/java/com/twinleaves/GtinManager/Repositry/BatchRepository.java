package com.twinleaves.GtinManager.Repositry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.twinleaves.GtinManager.Entity.Batch;

@Repository
public interface BatchRepository extends JpaRepository<Batch,Long>{
    List<Batch> findByGtin_Gtin(String gtin);
}
