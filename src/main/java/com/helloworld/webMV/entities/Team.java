package com.helloworld.webMV.entities;

import java.io.Serializable;
          
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
             

@Entity
public class Team implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTeam;

    @Column(length = 100, nullable = false)
    private String name;

    private Float budget;

    // Constructors
    public Team() {
    }

    public Team(String name, Float budget) {
        this.name = name;
        this.budget = budget;
    }

    public Team(Long idTeam, String name, Float budget) {
        this.idTeam = idTeam;
        this.name = name;
        this.budget = budget;
    }

    // Getters and Setters
    public Long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(Long idTeam) {
        this.idTeam = idTeam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getBudget() {
        return budget;
    }

    public void setBudget(Float budget) {
        this.budget = budget;
    }

    // toString Method
    @Override
    public String toString() {
        return "Team{" +
                "idTeam=" + idTeam +
                ", name='" + name + '\'' +
                ", budget=" + budget +
                '}';
    }
}