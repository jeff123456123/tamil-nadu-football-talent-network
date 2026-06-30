package com.football.service.impl;

import com.football.entity.District;
import com.football.repository.DistrictRepository;
import com.football.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class DistrictServiceImpl implements DistrictService {
    
    @Autowired
    private DistrictRepository districtRepository;
    
    @Override
    public District createDistrict(District district) {
        return districtRepository.save(district);
    }
    
    @Override
    public Optional<District> getDistrictById(Long id) {
        return districtRepository.findById(id);
    }
    
    @Override
    public List<District> getAllDistricts() {
        return districtRepository.findAll();
    }
    
    @Override
    public Optional<District> getDistrictByName(String name) {
        return districtRepository.findByName(name);
    }
    
    @Override
    public District updateDistrict(Long id, District districtDetails) {
        Optional<District> district = districtRepository.findById(id);
        if (district.isPresent()) {
            District existingDistrict = district.get();
            existingDistrict.setName(districtDetails.getName());
            return districtRepository.save(existingDistrict);
        }
        return null;
    }
    
    @Override
    public void deleteDistrict(Long id) {
        districtRepository.deleteById(id);
    }
}
