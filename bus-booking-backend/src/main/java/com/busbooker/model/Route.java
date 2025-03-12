// Route.java
package com.busbooker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "routes")
public class Route {
    @Id
    private String id;
    private String fromCityId;
    private String toCityId;
    private String busBrandId;
    private double fare;
}