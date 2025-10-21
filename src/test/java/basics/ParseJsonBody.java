package basics;
import static io.restassured.RestAssured.given;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class ParseJsonBody {
	@Test
public void parsingJsonBody() {
	Response res=given()
	.contentType(ContentType.JSON)
	.when()
	.get("http://localhost:3000/students");
	JSONArray jo=new JSONArray(res.asString());
	boolean status=false;
	for(int i=0;i<jo.length();i++) {
	String sname=jo.getJSONObject(i).get("name").toString();
	if(sname.equals("vineetha")) {
		status=true;
		break;
	}
	}
	Assert.assertEquals(status, true);
}
}
