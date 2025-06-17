package com.twinleaves.GtinManager.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twinleaves.GtinManager.Entity.Batch;
import com.twinleaves.GtinManager.Service.BatchService;

@RestController
@RequestMapping("/batches")
public class BatchController {
    @Autowired
    private BatchService batchService;

    @PostMapping
    public ResponseEntity<Batch> createBatch(@RequestBody Batch batch){
        Batch saved = batchService.saveBatch(batch);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/{gtin}")
    public ResponseEntity<List<Batch>> findbatchByGtin(@PathVariable String gtin){
        return ResponseEntity.ok(batchService.findbatchByGtin(gtin));
    }
}
