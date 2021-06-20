package RestAssuredAPI.Day3;

import java.util.ArrayList;
import java.util.List;
import RestAssuredAPI.Day3.Courses.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Main {
    public static void main(String[] args) {

        // Third
        List<WebAutomation> web = new ArrayList<>();
        var sel = new WebAutomation();
        sel.setCourseTitle("Selenium");
        sel.setPrice(4000);
        var java = new WebAutomation();
        java.setCourseTitle("Java");
        java.setPrice(5000);
        web.add(sel);
        web.add(java);

        List<ApiAutomation> api = new ArrayList<>();
        var rest = new ApiAutomation();
        rest.setCourseTitle("REST-Assured");
        rest.setPrice(3000);
        var soap = new ApiAutomation();
        soap.setCourseTitle("SOAP UI");
        soap.setPrice(3500);
        api.add(rest);
        api.add(soap);

        List<MobileAutomation> mobile = new ArrayList<>();
        var appium = new MobileAutomation();
        appium.setCourseTitle("Appium");
        appium.setPrice(4500);
        mobile.add(appium);


        // Second
        Courses courses = new Courses();
        courses.setWebAutomation(web);
        courses.setApiAutomation(api);
        courses.setMobileAutomation(mobile);

        // First
        var serviceDetails = new ServiceDetails();
        serviceDetails.setInstructor("Rafael");
        serviceDetails.setUrl("exelenter.com");
        serviceDetails.setServices("Software Testing");
        serviceDetails.setExpertise("Testing");
        serviceDetails.setCourses(courses); // this triggers 2nd step
        serviceDetails.setLinkedIn("linkedInId");

        Response postResponse = given()
                .auth().none()
                .contentType(ContentType.JSON)
                .when()
                .body(serviceDetails)
                .post("https://reqres.in/api/users");

        postResponse.prettyPrint();
    }
}
