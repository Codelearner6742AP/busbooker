// bus-booking-backend/src/main/java/com/busbooker/controller/BusController.java
package com.busbooker.controller;

import com.busbooker.model.BusBrand;
import com.busbooker.model.City;
import com.busbooker.model.Route;
import com.busbooker.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/buses")
public class BusController {

    @Autowired
    private BusService busService;

    @GetMapping("/brands")
    public List<BusBrand> getAllBusBrands() {
        return busService.getAllBusBrands();
    }

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return busService.getAllCities();
    }

    @GetMapping("/routes")
    public List<Route> findRoutes(
            @RequestParam String fromCityId,
            @RequestParam String toCityId) {
        return busService.findRoutes(fromCityId, toCityId);
    }

    @GetMapping("/booking-data")
    public Map<String, Object> getBookingData() {
        return busService.getBookingData();
    }

    @PostMapping("/initialize-data")
    public void initializeData() {
        busService.initializeSampleData();
    }
}