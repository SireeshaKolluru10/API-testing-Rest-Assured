package basics;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class PostRequestUsingExternalJson {
String id;
		@Test(priority=1)
		public void addStudent() throws FileNotFoundException {
			File f=new File(".//target//data.json");
			FileReader fr=new FileReader(f);
			JSONTokener jt=new JSONTokener(fr);
			JSONObject data=new JSONObject(jt);
			id=given()
			.contentType("application/json")
			.body(data.toString())
			.when()
			.post("http://localhost:3000/students")
			.then()
			.statusCode(201)
			.header("Content-Type", "application/json")
			.body("name",equalTo("Ishan"))
			.body("age",equalTo(26))
			.body("courses[0]", equalTo("Hindi"))
			.body("courses[1]",equalTo("Maths"))
			.log().all()
			.extract().path("id")
			;
			
		}
		@Test(priority=2,dependsOnMethods="addStudent")
		public void deleteStudent() {
			given()
			.when().delete("http://localhost:3000/students/"+id)
			.then()
			.statusCode(200)
			;
		}
	

}
