package com.example.onetomany.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Plant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int plantId;

    private String plantName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "des_id")
    private List<Description> des;

    public int getPlantId() {
        return plantId;
    }

    public void setPlantId(int plantId) {
        this.plantId = plantId;
    }

    public String getPlantName() {
        return plantName;
    }

    public void setPlantName(String plantName) {
        this.plantName = plantName;
    }

    public List<Description> getDes() {
        return des;
    }

    public void setDes(List<Description> des) {
        this.des = des;
    }

}