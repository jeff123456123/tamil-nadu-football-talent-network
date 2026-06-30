package com.football.controller;

import com.football.entity.District;
import com.football.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/districts")
@CrossOrigin(origins = "*")
public class DistrictController {
    
    @Autowired
    private DistrictService districtService;
    
    @PostMapping
    public ResponseEntity<District> createDistrict(@RequestBody District district) {
        District savedDistrict = districtService.createDistrict(district);
        return new ResponseEntity<>(savedDistrict, HttpStatus.CREATED);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<District> getDistrictById(@PathVariable Long id) {
        Optional<District> district = districtService.getDistrictById(id);
        return district.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @GetMapping
    public ResponseEntity<List<District>> getAllDistricts() {
        List<District> districts = districtService.getAllDistricts();
        return ResponseEntity.ok(districts);
    }
    
    @GetMapping("/name/{name}")
    public ResponseEntity<District> getDistrictByName(@PathVariable String name) {
        Optional<District> district = districtService.getDistrictByName(name);
        return district.map(ResponseEntity::ok)
                       .orElseGet(() -> ResponseEntity.notFound().build());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<District> updateDistrict(@PathVariable Long id, @RequestBody District districtDetails) {
        District updatedDistrict = districtService.updateDistrict(id, districtDetails);
        return updatedDistrict != null ? ResponseEntity.ok(updatedDistrict) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDistrict(@PathVariable Long id) {
        if (districtService.getDistrictById(id).isPresent()) {
            districtService.deleteDistrict(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
