package basics;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Headers.*;
import org.testng.annotations.Test;

import io.restassured.response.Response;
public class HeadersExmp {
	//@Test(priority=1)
	public void getHeaders() {
		given()
		.when()
		.get("https://www.google.com/")
		.then()
		.statusCode(200)
		.header("Content-Type","text/html; charset=ISO-8859-1")
		.header("Content-Encoding","gzip")
		.header("server","gws")
		.log().body();
	}
	//@Test
	public void getHeaderValue() {
		Response header=given()
		.when()
		.get("https://www.google.com/");
		String headerValue=header.getHeader("server");
		System.out.println(headerValue);
	}
	@Test
	public void getAllHeaders() {
		Response res=given()
		.when()
		.get("https://www.google.com/");
		Headers myheaders = res.getHeaders();
		for(Header h:myheaders) {
			String name=h.getName();
			System.out.println(name+"=======> "+" value is: "+h.getValue());
		}
	}
}
