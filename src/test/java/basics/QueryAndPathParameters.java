package basics;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class QueryAndPathParameters {
	
	//https://reqres.in/api/users?page=2&id=5
@Test
		public void usingQueryAndPathParameters() {
			given()
			.pathParam("path","users")
			.queryParam("page", 2)
			//.queryParam("id",10)
			.when()
			.get("https://reqres.in/api/{path}")
			.then()
			.statusCode(200)
			.log().body();
			
		}
	}


