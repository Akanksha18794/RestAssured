import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class PostRequest {
	
	@Test
	public void Postreq() {
		baseURI = "https://reqres.in";
		
		JSONObject request = new JSONObject();
		request.put("email", "eve.holt@reqres.in");
		request.put("password", "pistol");
		
		System.out.println(request.toJSONString());
		
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).
		when().post("/api/register").then().statusCode(200).log().all();
	}

}
