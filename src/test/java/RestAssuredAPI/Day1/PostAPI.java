package RestAssuredAPI.Day1;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostAPI {

    public static void main(String[] args) {
        System.out.println("Creating User using Post request\n=========================");

        String payload = "{\"name\": \"morpheus\", \"job\" : \"leader\"}";

        Response postResponse = given()
                .auth().none()
                .contentType(ContentType.JSON)
                .when()
                .body(payload)
                .post("https://reqres.in/api/users");

//        System.out.println(postResponse.asString());
//        System.out.println(postResponse.statusCode());
        postResponse.prettyPrint();

        System.out.println("=====================\nUser created successfully");
    }
}
