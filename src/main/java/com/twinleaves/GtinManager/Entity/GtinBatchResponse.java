package com.twinleaves.GtinManager.Entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GtinBatchResponse {
    private String gtin;
    private List<Batch>batches;
}
