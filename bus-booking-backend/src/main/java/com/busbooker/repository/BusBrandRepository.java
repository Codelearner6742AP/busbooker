package com.busbooker.repository;

import com.busbooker.model.BusBrand;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BusBrandRepository extends MongoRepository<BusBrand, String> {
}