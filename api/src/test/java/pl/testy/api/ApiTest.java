package pl.testy.api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.testy.api.model.ErrorResponse;
import pl.testy.api.model.User;
import pl.testy.api.model.User2;
import pl.testy.api.service.UserService;
import pl.testy.api.specification.Specification;

import java.util.List;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

@DisplayName("Mega Api Test")
public class ApiTest {

    @Test
    @DisplayName("pierwszy test")
    public void _1Test(){

        RestAssured.given().spec(Specification.requestSpecBuilder())
                .when()
                .get("5a6b69ec3100009d211b8aeb")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo("Piotr"))
                .body("surname", equalTo("Kowalski"));

    }


    @Test
    @DisplayName("drugi test")
    public void _2Test(){

        RestAssured.given().spec(Specification.requestSpecBuilder())
                .when()
                .get("5a6a58222e0000d0377a7789")
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("[0].imie", equalTo("Piotr"))
                .body("[0].nazwisko", equalTo("Kowalski"))
                .body("[0].device[0].type", equalTo("computer"));
                //.body("[0].device[0].device.model.produce", equalTo("dell"));

    }


    @Test
    @DisplayName("trzeci test")
    public void _3Test(){


        List<User> users = UserService.getUsers();
        assertThat(users.get(0).device.get(0).type,  equalTo("computer"));
        assertThat(users.get(0).device.get(0).deviceModel.get(0).produce, equalTo("dell"));
        assertThat(users.get(0).device.get(0).deviceModel.get(0).screenSize, is(17.0));

    }

    @Test
    @DisplayName("trzeci, ale w inneh wersji test")
    public void _3PrimeTest(){


        List<User> users = UserService.getUsersResponse();
        assertThat(users.get(0).device.get(0).type,  equalTo("computer"));
        assertThat(users.get(0).device.get(0).deviceModel.get(0).produce, equalTo("dell"));
        assertThat(users.get(0).device.get(0).deviceModel.get(0).screenSize, is(17.0));

    }


    @Test
    @DisplayName("4ty test")
    public void _4Test(){
//albo tak aby tak
       // User2 user = UserService.getMyUser();
        User2 user = UserService.getUser2Response();
        assertThat(user.name,  equalTo("Piotr"));
        assertThat(user.surname,  equalTo("Kowalski"));

    }


    @Test
    @DisplayName("5ty error test")
    public void _5ErrorTest(){
        ErrorResponse  errorResponse =  RestAssured.given()
                .spec(Specification.requestSpecBuilder())
                .when()
                .get("5a690b452e000054007a73cd")
                .then()
                .assertThat()
                .statusCode(400)
                .extract()
                .body()
                .jsonPath()
                .getObject("", ErrorResponse.class);

        assertThat(errorResponse.error.code, is(400));
        assertThat(errorResponse.error.validationError, equalTo("invalid_email"));
        assertThat(errorResponse.error.message, equalTo("your email is invalid"));

    }
}
