package RestAssuredAPI.Day2;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.*;

import static io.restassured.RestAssured.given;

public class PostAPI2 {
    public static void main(String[] args) {

        Map<String, Object> map = new HashMap<>();
        map.put("name", "said");
        map.put("job", "tester");

        List<String> skills = new ArrayList<>();
        skills.add("Java");
        skills.add("Selenium");

        map.put("skills", skills);

        Map<String, Object> details = new HashMap<>();
        details.put("phone", "123-345-3424");
        details.put("email", "said@gmail.com");

        map.put("details", details);


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
    }
}
