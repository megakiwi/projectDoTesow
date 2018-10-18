package pl.testy.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserDb {
    private int id;
    private String name;
    private String surname;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public UserDb() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public UserDb(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }
}
