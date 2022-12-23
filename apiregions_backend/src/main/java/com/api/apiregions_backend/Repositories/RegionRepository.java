package com.api.apiregions_backend.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.apiregions_backend.Modeles.Region;



@Repository
public interface RegionRepository extends JpaRepository<Region, Long> {
}