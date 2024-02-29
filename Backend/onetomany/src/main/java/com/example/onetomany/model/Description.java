package com.example.onetomany.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int descId;

    private String plantLight;
    private String plantSoil;
    private String plantWater;
    private String tempHumi;

    public Description() {
    }

    public Description(int descId, String plantLight, String plantSoil, String plantWater, String tempHumi) {
        this.descId = descId;
        this.plantLight = plantLight;
        this.plantSoil = plantSoil;
        this.plantWater = plantWater;
        this.tempHumi = tempHumi;
    }

    public int getDescId() {
        return descId;
    }

    public void setDescId(int descId) {
        this.descId = descId;
    }

    public String getPlantLight() {
        return plantLight;
    }

    public void setPlantLight(String plantLight) {
        this.plantLight = plantLight;
    }

    public String getPlantSoil() {
        return plantSoil;
    }

    public void setPlantSoil(String plantSoil) {
        this.plantSoil = plantSoil;
    }

    public String getPlantWater() {
        return plantWater;
    }

    public void setPlantWater(String plantWater) {
        this.plantWater = plantWater;
    }

    public String getTempHumi() {
        return tempHumi;
    }

    public void setTempHumi(String tempHumi) {
        this.tempHumi = tempHumi;
    }

}