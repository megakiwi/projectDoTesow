package pl.testy.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserAzure {
    @JsonProperty("ID")
    public int id;
    @JsonProperty("UserName")
    public String userName;

    @JsonProperty("Password")
    public String password;
}
