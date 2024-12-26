package com.sithu.springdatajdbc.lesson.bean;

import java.util.Date;

public class Player {
    private int id;
    private String name;
    private String nationality;
    private Date birthdayDate;
    private int titles;

    //no-arg constructor is a requirement of the BeanPropertyRowMapper
    public Player(){

    }
    public Player(int id, String name, String nationality, Date birthdayDate, int titles) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.birthdayDate = birthdayDate;
        this.titles = titles;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nationality='" + nationality + '\'' +
                ", birthdayDate=" + birthdayDate +
                ", titles=" + titles +
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public int getTitles() {
        return titles;
    }

    public void setTitles(int titles) {
        this.titles = titles;
    }
}
