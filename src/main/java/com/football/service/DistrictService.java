package com.football.service;

import com.football.entity.District;
import java.util.List;
import java.util.Optional;

public interface DistrictService {
    District createDistrict(District district);
    
    Optional<District> getDistrictById(Long id);
    
    List<District> getAllDistricts();
    
    Optional<District> getDistrictByName(String name);
    
    District updateDistrict(Long id, District districtDetails);
    
    void deleteDistrict(Long id);
}
