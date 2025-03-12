// CityRepository.java
package com.busbooker.repository;

import com.busbooker.model.City;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CityRepository extends MongoRepository<City, String> {
}
