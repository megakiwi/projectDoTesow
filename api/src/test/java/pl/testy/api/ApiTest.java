package pl.testy.api;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.testy.api.dbservice.UserDao;
import pl.testy.api.jdbiservice.UserJdbiService;
import pl.testy.api.model.*;
import pl.testy.api.service.UserService;
import pl.testy.api.specification.Specification;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


import static org.awaitility.Awaitility.await;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Mega Api Test")
public class ApiTest {

    @Test
    @DisplayName("pierwszy test")
    public void _1Test() {

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
    public void _2Test() {

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
    public void _3Test() {


        List<User> users = UserService.getUsers();
        assertThat(users.get(0).device.get(0).type, equalTo("computer"));
        assertThat(users.get(0).device.get(0).deviceModel.get(0).produce, equalTo("dell"));
        assertThat(users.get(0).device.get(0).deviceModel.get(0).screenSize, is(17.0));

    }

    @Test
    @DisplayName("trzeci, ale w inneh wersji test")
    public void _3PrimeTest() {


        List<User> users = UserService.getUsersResponse();
        assertThat(users.get(0).device.get(0).type, equalTo("computer"));
        assertThat(users.get(0).device.get(0).deviceModel.get(0).produce, equalTo("dell"));
        assertThat(users.get(0).device.get(0).deviceModel.get(0).screenSize, is(17.0));

    }


    @Test
    @DisplayName("4ty test")
    public void _4Test() {
//albo tak aby tak
        // User2 user = UserJdbiService.getMyUser();
        User2 user = UserService.getUser2Response();
        assertThat(user.name, equalTo("Piotr"));
        assertThat(user.surname, equalTo("Kowalski"));

    }


    @Test
    @DisplayName("5ty error test")
    public void _5ErrorTest() {
        ErrorResponse errorResponse = RestAssured.given()
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

    @Test
    @DisplayName("6ty post")
    public void _6PostTest() {
        User2 user = new User2("Rafal", "Wrobel");

        String[] responsePost = UserService.postUser2(user);

        System.out.println(responsePost);
        assertTrue(Arrays.asList(responsePost).isEmpty());
    }

    @Test
    @DisplayName("7ty generic integer")
    public void _7GenercicIntegerTest() throws IOException {
        Response response = UserService.getGeneric("/5b05bf3f3200007100ebfa04");

        ObjectMapper objectMapper = new ObjectMapper();

        UserGeneric<Integer> user = objectMapper.readValue(
                response.then().extract().body().asInputStream(),
                new TypeReference<UserGeneric<Integer>>() {
                }
        );
        assertThat(user.id, is(1));
    }


    @Test
    @DisplayName("7ty generic string")
    public void _7GenercicStringTest() throws IOException {
        Response response = UserService.getGeneric("/5b05c83e3200009700ebfa2b");

        ObjectMapper objectMapper = new ObjectMapper();

        UserGeneric<String> user = objectMapper.readValue(
                response.then().extract().body().asInputStream(),
                new TypeReference<UserGeneric<String>>() {
                }
        );
        assertThat(user.id, equalTo("1a"));
    }


    @Test
    @DisplayName("8ty user azure")
    public void _8UserAzureTest() throws IOException {
        UserAzure user = UserService.getUserAzureById(1);

        assertThat(user.id, is(1));
        assertThat(user.userName, equalTo("User 1"));
        assertThat(user.password, equalTo("Password1"));
    }



    @Test
    @DisplayName("db 1")
    public void _1DBTest() throws IOException {
        UserDb user = UserDao.getfindById(1);

        List<UserDb> userList = UserDao.getAll();


 // testy poniższe dzialaja, tylko  kometujemy bo mamy juz usera o takim userze
       // UserDao.saveOne(new UserDb(6,"sdfgfgg", "dfdgfd"));


        UserDao.update(new UserDb(4,"sdfgfggUpdated", "dfdgfd"),4);

    }



    @Test
    @DisplayName("db await")
    public void _awaitTest()  {
        await().untilAsserted(() -> {
            assertThat(UserService.getUserAzureById(1).id, is(1));
            assertThat(UserDao.getfindById(1).getId(), is(1));

        });
    }


    @Test
    @DisplayName("jdbi await")
    public void _jdbiTest()  {
      assertThat(UserJdbiService.getTestUser(1L).getId(), is(1L));
    }

}
