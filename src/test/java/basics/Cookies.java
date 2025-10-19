package basics;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;
import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.response.Response;
@Test
public class Cookies {
	public void getCookies() {
		 Response cookie = given()
		.when()
		.get("https://www.google.com/");
		//.then()
		
		Map<String,String>cookies=cookie.getCookies();
		for(String k:cookies.keySet()) {
			String val=cookie.getCookie(k);
			System.out.println(k+" cookie value: "+val);
		}
	}

}
