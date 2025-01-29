package com.sithu.databaserelationship.onetoone;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.sithu.databaserelationship.onetomany.Registration;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Player {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToOne(cascade = CascadeType.ALL,optional = false)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    @JsonManagedReference
    private PlayerProfile playerProfile;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<Registration> registrations = new ArrayList<>();

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    public Player(String name, PlayerProfile playerProfile) {
        this.name = name;
        this.playerProfile = playerProfile;
    }

    public Player() {

    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
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

    public PlayerProfile getPlayerProfile() {
        return playerProfile;
    }

    public void setPlayerProfile(PlayerProfile playerProfile) {
        this.playerProfile = playerProfile;
    }

    public void registerPlayer(Registration registration) {
        this.registrations.add(registration);
        registration.setPlayer(this);
    }
}
