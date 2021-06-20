package RestAssuredAPI.Day1;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class PostAPI_HashMap {

    public static void main(String[] args) {
        System.out.println("Creating User using Post request");

//        String payload = "{\"name\": \"morpheus\", \"job\" : \"leader\"}";

        Map<String, String> map = new HashMap<>();
        map.put("name", "morpheus");
        map.put("job", "leader");

        Response postResponse = given()
                .auth().none()
                .contentType(ContentType.JSON)
                .when()
                .body(map)
//                .body(new File("./Payload.json"))
//                .log().all()
                .post("https://reqres.in/api/users");
//
//        System.out.println(postResponse.asString());
//        System.out.println(postResponse.statusCode());
        postResponse.prettyPrint();

        System.out.println("User created successfully");
    }
}
