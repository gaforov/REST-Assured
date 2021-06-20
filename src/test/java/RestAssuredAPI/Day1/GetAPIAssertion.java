package RestAssuredAPI.Day1;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class GetAPIAssertion {
    public static void main(String[] args) {

       /*
       REST-Assured SYNTAX

        given() --------------------------> Pre-requisites: given provided pre-requisites (params, auth, header, formatType(json, xml, html))
            header()
            contentType()
        when()  --------------------------> Action/Call: which method request type is called (get, post, put, delete)
            get("URI")
        then()  --------------------------> Result/Outcome/Response: then perform this (validation, assertion, printPretty, etc)
         */

        System.out.println("First API Test Case");

        given().param("page", "2").auth().none()
//                .header("Content-Type","application.json") //postman-header, you can use either this or line below
                .contentType(ContentType.JSON) //postman->body->formatType(xml,json,text,yaml)
                .when()
                .get("https://reqres.in/api/users")
                .then()
//                .log().all()
                .statusCode(200) //assertStatusCode
                .body("page", equalTo(2),
                        "per_page", equalTo(6));  //assertBody, can assert more than one

        System.out.println("Executed Successfully");

    }
}