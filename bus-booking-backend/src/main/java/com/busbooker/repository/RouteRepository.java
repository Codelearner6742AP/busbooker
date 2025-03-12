// RouteRepository.java
package com.busbooker.repository;

import com.busbooker.model.Route;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface RouteRepository extends MongoRepository<Route, String> {
    List<Route> findByFromCityIdAndToCityId(String fromCityId, String toCityId);
    List<Route> findByBusBrandId(String busBrandId);
}