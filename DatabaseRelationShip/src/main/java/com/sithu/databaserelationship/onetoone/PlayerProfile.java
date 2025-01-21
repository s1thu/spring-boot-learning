package com.sithu.databaserelationship.onetoone;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class PlayerProfile {

    @Id
    @GeneratedValue
    private int id;
    private String twitter;

    public PlayerProfile(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    @Override
    public String toString() {
        return "PlayerProfile{" +
                "id=" + id +
                ", twitter='" + twitter + '\'' +
                '}';
    }
}
