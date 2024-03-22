import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutRequest {
	
	@Test
	public void Putrequest() {
		
		JSONObject request = new JSONObject();
		request.put("name", "Anita");
		request.put("job", "Teacher");
		System.out.println(request.toJSONString());
		
		baseURI = "https://reqres.in/api/";
		
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).
		when().put("/users/2").then().statusCode(200).log().all();
}
}
