package RestAssuredAPI.Day1;
import io.restassured.http.ContentType;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostAPIAssertion {

    public static void main(String[] args) {
        System.out.println("Creating User using Post request");

        String payload = "{\"name\": \"morpheus\", \"job\" : \"leader\"}";

        given()
                .auth().none()
                .contentType(ContentType.JSON)
                .when()
                .body(payload)
                .post("https://reqres.in/api/users")
                .then()//then is mandatory here
                .statusCode(201)
                .body("name",equalTo("morpheus"),
                        "job", equalTo("leader"));

        System.out.println("User created successfully");



    }
}
