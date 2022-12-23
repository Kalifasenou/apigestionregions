package com.api.apiregions_backend.Controleurs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.api.apiregions_backend.Modeles.Region;
import com.api.apiregions_backend.Repositories.RegionRepository;

@RestController
@RequestMapping("/api/regions")
public class RegionController {

    @Autowired
    private RegionRepository regionRepository;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Region> createRegion(@RequestBody Region region) {
        Region createdRegion = regionRepository.save(region);
        return new ResponseEntity<>(createdRegion, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Region> updateRegion(@PathVariable Long id, @RequestBody Region region) {
        Region regionInDb = regionRepository.findById(id).orElse(null);
        if (regionInDb == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        regionInDb.setName(region.getName());
        regionInDb.setDescription(region.getDescription());
        regionInDb.setGeolocation(region.getGeolocation());
        regionInDb.setArea(region.getArea());
        regionInDb.setPopulationSize(region.getPopulationSize());
        Region updatedRegion = regionRepository.save(regionInDb);
        return new ResponseEntity<>(updatedRegion, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteRegion(@PathVariable Long id) {
        regionRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Region>> getAllRegions() {
        List<Region> regions = regionRepository.findAll();
        return new ResponseEntity<>(regions, HttpStatus.OK);
    }
}
