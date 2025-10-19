package basics;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
public class HttpRequests {
	String id;
 @Test(priority=1)
	void getUsers() {
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.log().all();
	}
 //@Test(priority=2)
 void createUser() {
	 HashMap<String, String> data=new HashMap<>();
	 data.put("name","kevin");
	 data.put("job", "player");
	 id=given()
	 .contentType("application/json")
	 .body(data)
	 .when()
	 .post("https://reqres.in/api/users")
	.jsonPath().getString("id");
 }
 //@Test(priority=3)
 void updateUser() {
	 HashMap<String,String> data=new HashMap<>();
	 data.put("name", "loki");
	 data.put("job","philosopher");
	 given()
	 .contentType("application/json")
	 .body(data)
	 .when()
	 .put("https://reqres.in/api/users"+id)
	 .then()
	 .log().all();
 }
// @Test(priority=4)
 void deleteUser() {
	 given()
	 .when()
	 .delete("https://reqres.in/api/users/2")
	 .then()
	 .statusCode(204);
 }
}
