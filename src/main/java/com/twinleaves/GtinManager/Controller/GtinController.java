package com.twinleaves.GtinManager.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twinleaves.GtinManager.Entity.Gtin;
import com.twinleaves.GtinManager.Entity.GtinBatchResponse;
import com.twinleaves.GtinManager.Service.GtinService;

@RestController
@RequestMapping("/gtins")
public class GtinController {
    @Autowired
    private GtinService gtinService;

    @PostMapping
    public ResponseEntity<Gtin> createGtin(@RequestBody Gtin gtin){
        Gtin saved=gtinService.createGtin(gtin);
        return ResponseEntity.ok(saved);
    }
    @GetMapping("/gtinBatches")
    public ResponseEntity<List<GtinBatchResponse>> getFilteredBatches(){
        return ResponseEntity.ok(gtinService.getFilteredBatches());
    }
}
