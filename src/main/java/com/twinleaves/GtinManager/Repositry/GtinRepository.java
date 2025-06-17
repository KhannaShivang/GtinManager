package com.twinleaves.GtinManager.Repositry;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.twinleaves.GtinManager.Entity.Gtin;

@Repository
public interface GtinRepository extends JpaRepository<Gtin,Long>{
    Optional<Gtin> findByGtin(String Gtin);

    @Query("Select g.gtin From Gtin g")
    List<String> findAllGtinCode();
}
