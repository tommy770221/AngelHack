package com.angelhack.mapteam.repository;

import com.angelhack.mapteam.model.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country,Integer> {
    
}