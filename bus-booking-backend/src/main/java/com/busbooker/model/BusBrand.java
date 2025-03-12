package com.busbooker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

@Data
@Document(collection = "busBrands")
public class BusBrand {
    @Id
    private String id;
    private String name;
    private double rating;
}