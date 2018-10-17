package pl.testy.api.service;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pl.testy.api.model.User;
import pl.testy.api.model.User2;
import pl.testy.api.specification.Specification;

import java.util.Arrays;
import java.util.List;

public class UserService {
    private static final String URL_USER = "5a6b69ec3100009d211b8aeb";
    private static final String URL_USERS = "5a6a58222e0000d0377a7789";

    public static User2 getMyUser() {
        return RestAssured.given()
                .spec(Specification.requestSpecBuilder())
                .when()
                .get(URL_USER)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getObject("", User2.class);
    }

    public static List<User> getUsers() {
        return RestAssured.given()
                .spec(Specification.requestSpecBuilder())
                .when()
                .get(URL_USERS)
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .jsonPath()
                .getList("", User.class);
    }



    public static User2 getUser2Response(){
        return RestAssured.given()
                .spec(Specification.requestSpecBuilder())
                .when()
                .get(URL_USER)
                .andReturn()
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .as(User2.class);
    }

    public static List<User> getUsersResponse(){
        return Arrays.asList(RestAssured.given()
                .spec(Specification.requestSpecBuilder())
                .when()
                .get(URL_USERS)
                .andReturn()
                .then()
                .assertThat()
                .statusCode(200)
                .extract()
                .body()
                .as(User [].class));
    }

}
