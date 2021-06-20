package RestAssuredAPI.Day2;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import static io.restassured.RestAssured.given;

/*

{
    "name" : "Said",
    "job" : "Tester",
    "skills" : ["Java, Selenium"],
    "details" : {
        "phone" : "123-345-3424",
        "email" : "said@gmail.com"
    }
}
 */
public class PostAPI3 {
    public static void main(String[] args) {

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Said");
        jsonObject.put("job", "tester");

        JSONArray skills = new JSONArray();
        skills.put("java");
        skills.put("selenium");

        jsonObject.put("skills", skills);

        JSONObject details = new JSONObject();
        details.put("phone", "123-234-4567");
        details.put("email", "saidtest@gmail.com");

        jsonObject.put("details", details);

        Response postResponse = given()
                .auth().none()
                .contentType(ContentType.JSON)
                .when()
                .body(jsonObject.toString())
//                .body(new File("./Payload.json"))
//                .log().all()
                .post("https://reqres.in/api/users");


        postResponse.prettyPrint();

    }

}
