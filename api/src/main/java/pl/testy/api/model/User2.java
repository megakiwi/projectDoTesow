package pl.testy.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User2 {
    public String name;

    public String surname;

    public User2() {
    }

    public User2(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
