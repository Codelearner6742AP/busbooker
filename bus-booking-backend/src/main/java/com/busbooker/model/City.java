// City.java
package com.busbooker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "cities")
public class City {
    @Id
    private String id;
    private String name;
}
