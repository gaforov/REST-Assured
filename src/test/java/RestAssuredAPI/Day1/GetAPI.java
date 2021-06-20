package RestAssuredAPI.Day1;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetAPI {
    public static void main(String[] args) {

//        System.out.println("First API Test Case\n*****************");

        Response getResponse = given()
                .param("page", "2").auth().none()
                .contentType(ContentType.JSON)
                .get("https://reqres.in/api/users");

        getResponse.prettyPrint();
//        System.out.println("Response as String = " + getResponse.asString());
//        System.out.println("Response Status Code = " + getResponse.statusCode());
//        System.out.println("Response time (ms) = " + getResponse.getTime());

//        System.out.println("******************\nExecuted Successfully");
    }
}
