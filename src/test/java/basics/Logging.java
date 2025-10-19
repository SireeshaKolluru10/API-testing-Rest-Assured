package basics;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Logging {
@Test
	public void getLogs() {
		given()
		.when()
		.get("https://www.google.com/")
		.then()
		.statusCode(200)
		//.log().cookies();
		//.log().headers();
		//.log().body()
		.log().status();
	}
}
