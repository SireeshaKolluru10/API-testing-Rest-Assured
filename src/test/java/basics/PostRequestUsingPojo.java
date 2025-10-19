package basics;

import org.testng.annotations.Test;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class PostRequestUsingPojo {
String id;
		@Test(priority=1)
		public void addStudent() {
			PojoClass data=new PojoClass();
			data.setName("loki");
			data.setAge(24);
			String[] courses= {"English","Physics"};
			data.setCourses(courses);
			id=given()
			.contentType("application/json")
			.body(data)
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
