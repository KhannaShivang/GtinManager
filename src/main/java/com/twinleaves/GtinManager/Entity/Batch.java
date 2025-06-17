package com.twinleaves.GtinManager.Entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Batch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long batchId;

    private int mrp;
    private int sp;
    private int purchasePrice;
    private int availableQuantity;
    private LocalDate inwardedOn;
    @ManyToOne
    @JoinColumn(name = "gtin_id")
    private Gtin gtin;
}
