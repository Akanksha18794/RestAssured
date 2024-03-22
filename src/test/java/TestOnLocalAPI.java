import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class TestOnLocalAPI {
	
	//@Test
	public void GetRequest() {
	
		baseURI = "http://localhost:3000";
		given().get("/users").then().statusCode(200).log().all();
	}
	
	//@Test
	public void PostRequest() {
	
		JSONObject request = new JSONObject();
		request.put("firstName", "Thomas");
		request.put("lastName", "Edison");
		request.put("subjectId", "1");
		
		baseURI = "http://localhost:3000";
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString()).when()
		.post("/users").then().
		statusCode(201).log().all();
	}
	
	//@Test
	public void PutRequest() {
	
		JSONObject request = new JSONObject();
		request.put("firstName", "Albert");
		request.put("lastName", "Einstein");
		request.put("subjectId", "2");
		
		baseURI = "http://localhost:3000";
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString()).when()
		.put("/users/3bf4").then().
		statusCode(200).log().all();
	}
	
	//@Test
	public void PatchRequest() {
	
		JSONObject request = new JSONObject();
		request.put("lastName", "Doe");
		
		baseURI = "http://localhost:3000";
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString()).when()
		.patch("/users/3bf4").then().
		statusCode(200).log().all();
	}
	
	@Test
	public void DeleteRequest() {
		
		baseURI = "http://localhost:3000";
		when().delete("/users/3bf4").then().statusCode(200);
	}
}
