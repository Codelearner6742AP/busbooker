package com.busbooker.service;

import com.busbooker.model.BusBrand;
import com.busbooker.model.City;
import com.busbooker.model.Route;
import com.busbooker.repository.BusBrandRepository;
import com.busbooker.repository.CityRepository;
import com.busbooker.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BusService {

    @Autowired
    private BusBrandRepository busBrandRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private RouteRepository routeRepository;

    public List<BusBrand> getAllBusBrands() {
        return busBrandRepository.findAll();
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public List<Route> findRoutes(String fromCityId, String toCityId) {
        return routeRepository.findByFromCityIdAndToCityId(fromCityId, toCityId);
    }

    // This method can be used to provide data for the booking page
    public Map<String, Object> getBookingData() {
        List<BusBrand> busBrands = busBrandRepository.findAll();
        List<City> cities = cityRepository.findAll();

        return Map.of(
                "busBrands", busBrands,
                "cities", cities
        );
    }

    // Initialize sample data for testing
    public void initializeSampleData() {
        // Only initialize if no data exists
        if (busBrandRepository.count() == 0 && cityRepository.count() == 0) {
            // Create bus brands
            BusBrand luxuryLines = new BusBrand();
            luxuryLines.setName("Luxury Lines");
            luxuryLines.setRating(4.5);
            busBrandRepository.save(luxuryLines);

            BusBrand expressTransit = new BusBrand();
            expressTransit.setName("Express Transit");
            expressTransit.setRating(4.2);
            busBrandRepository.save(expressTransit);

            BusBrand comfortCoaches = new BusBrand();
            comfortCoaches.setName("Comfort Coaches");
            comfortCoaches.setRating(4.3);
            busBrandRepository.save(comfortCoaches);

            BusBrand premierBus = new BusBrand();
            premierBus.setName("Premier Bus");
            premierBus.setRating(4.7);
            busBrandRepository.save(premierBus);

            // Create cities
            List<String> cityNames = List.of("Delhi", "Mumbai", "Bangalore", "Pune", "Kolkata", "Indore", "Amritsar");
            List<City> savedCities = cityNames.stream().map(name -> {
                City city = new City();
                city.setName(name);
                return cityRepository.save(city);
            }).collect(Collectors.toList());

            // Create sample routes between cities with different bus brands
            for (int i = 0; i < savedCities.size(); i++) {
                for (int j = 0; j < savedCities.size(); j++) {
                    if (i != j) {
                        List<BusBrand> brands = busBrandRepository.findAll();
                        for (BusBrand brand : brands) {
                            Route route = new Route();
                            route.setFromCityId(savedCities.get(i).getId());
                            route.setToCityId(savedCities.get(j).getId());
                            route.setBusBrandId(brand.getId());
                            // Set a random fare between 500 and 3000
                            route.setFare(500 + Math.random() * 2500);
                            routeRepository.save(route);
                        }
                    }
                }
            }
        }
    }
}