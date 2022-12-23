package com.api.apiregions_backend.Modeles;

import javax.persistence.*;

@Entity
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String geolocation;
    private Double area;
    private Long populationSize;
    public Object getName() {
        return null;
    }
    public void setName(Object name2) {
    }
    public Object getDescription() {
        return null;
    }
    public void setDescription(Object description2) {
    }
    public Object getGeolocation() {
        return null;
    }
    public void setGeolocation(Object geolocation2) {
    }
    public Object getArea() {
        return null;
    }
    public void setArea(Object area2) {
    }
    public Object getPopulationSize() {
        return null;
    }
    public void setPopulationSize(Object populationSize2) {
    }

}


