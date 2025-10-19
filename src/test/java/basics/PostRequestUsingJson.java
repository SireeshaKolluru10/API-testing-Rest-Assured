package basics;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class PostRequestUsingJson {
String id;
		//@Test(priority=1)
		public void addStudent() {
			JSONObject data=new JSONObject();
			data.put("name","loki");
			data.put("age",24);
			String[] course= {"English","Physics"};
			data.put("courses",course);
			id=given()
			.contentType("application/json")
			.body(data.toString())
			.when()
			.post("http://localhost:3000/students")
			.then()
			.statusCode(201)
			.header("Content-Type", "application/json")
			.body("name",equalTo("loki"))
			.body("age",equalTo(24))
			.body("courses[0]", equalTo("English"))
			.body("courses[1]",equalTo("Physics"))
			.extract().path("id")
			;
		}
		@Test(priority=2)
		public void deleteStudent() {
			given()
			.when().delete("http://localhost:3000/students/"+id)
			.then()
			.statusCode(200)
			;
		}
	

}
