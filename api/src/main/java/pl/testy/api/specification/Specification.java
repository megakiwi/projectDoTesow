package pl.testy.api.specification;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import pl.testy.api.configuration.Configuration;

public class Specification {

    public static RequestSpecification requestSpecBuilder(){
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(Configuration.URL)
                .setBasePath("v2/").build();

    }

    public static RequestSpecification requestSpecBuilderAuth(){
        return new RequestSpecBuilder()
                .addHeader("Aithorise", "Apikey, lolik")
                .setContentType(ContentType.JSON)
                .setBaseUri(Configuration.URL)
                .setBasePath("v2/").build();

    }

    public static RequestSpecification fakeAzurSpecBuilder(){
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("http://fakerestapi.azurewebsites.net")
                .build();

    }
}
