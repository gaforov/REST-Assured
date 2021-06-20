package RestAssuredAPI.Day2;

/*
{
  "name": "Said",
  "job": "Tester",
  "skills": ["Java, Selenium"],
  "details": {
    "phone": "123-345-3424",
    "email": "said@gmail.com"
  }
}
 */

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;

public class PostAPI_Pojo {
    public static void main(String[] args) {
        Employee employee = new Employee
                ("Said","Tester",new String[]{"java","selenium"},"123-456-7890","testing@gmail.com");

        Response postResponse = given()
                .auth().none()
                .contentType(ContentType.JSON)
                .when()
                .body(employee)
//                .log().all()
                .post("https://reqres.in/api/users");

//        postResponse.prettyPrint();
        String name = postResponse.getBody().path("name");
//        System.out.println("name1 = " + name);
        String job = postResponse.getBody().path("job");
        String skill = postResponse.getBody().path("skills[0]");
        String phone = postResponse.getBody().path("details.phone");
//        System.out.println("Name = " + name +  "\nTitle = " + job + "\nSkill = " + skill + "\nPhone = " + phone);

//        //another way to access name/job/email
//        name = postResponse.jsonPath().get("name");
//        System.out.println("name2 = " + name);

        Assert.assertEquals(postResponse.getBody().path("name"), "Said");
        Assert.assertEquals(job,"Tester");
        Assert.assertEquals(skill,"java");
        Assert.assertEquals(phone,"123-456-7890");
    }


}
