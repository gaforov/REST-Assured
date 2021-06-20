package RestAssuredAPI.Day3;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import RestAssuredAPI.Day3.Courses.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Main {
    public static void main(String[] args) throws IOException {

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

        //Forth Serialization
        ObjectMapper objectMapper = new ObjectMapper();
        String valueAsString = objectMapper.writeValueAsString(serviceDetails); //replace .body(serviceDetails) with valueAsString
//        String userDirectory = System.getProperty("user.dir");
//        File outputJsonFile = new File(userDirectory + "/src/test/resources/Payload.json");
//        objectMapper.writerWithDefaultPrettyPrinter().writeValue(outputJsonFile, serviceDetails);

        Response postResponse = given()
                .auth().none()
                .contentType(ContentType.JSON)
                .when()
                .body(valueAsString)
                .post("https://reqres.in/api/users");

        postResponse.prettyPrint();

        // Fifth Deserialization
//        String responseAsString = postResponse.asString();
//        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//        ServiceDetails sDetails = objectMapper.readValue(responseAsString, ServiceDetails.class);
//        String instructor = sDetails.getInstructor();
//        String courseTitle = sDetails.getCourses().getApiAutomation().get(0).getCourseTitle();
//        System.out.println(instructor);
//        System.out.println(courseTitle);

    }
}
