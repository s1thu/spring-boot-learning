package com.sithu.databaserelationship.onetomany;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String location;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="tournament_id")
    private List<Registration> registrations = new ArrayList<>();

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    @Override
    public String toString() {
        return "Tournament{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", registrations=" + registrations +
                '}';
    }

    public void addRegistration(Registration registration) {
        this.registrations.add(registration);
    }

    public void removeRegistration(Registration registration) {
        if (registration != null)
            this.registrations.remove(registration);
    }

    public Tournament(String name, String location, List<Registration> registrations) {
        this.name = name;
        this.location = location;
        this.registrations = registrations;
    }

    public Tournament() {}

    public Tournament(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
