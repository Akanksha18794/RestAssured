import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matcher;

public class GETRequest {
	
	@Test (priority = 1)
	public void Test1() {
	
		Response response = get("https://reqres.in/api/users?page=2");
		
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is: " + responseBody);
		
		int responseCode = response.getStatusCode();
		System.out.println("Response Code is: " + responseCode);
		
		long responseTime = response.getTime();
		System.out.println("Response Time is: " + responseTime);
	
		String StatusLine = response.getStatusLine();
		System.out.println("Response Status Line is: " + StatusLine);
	
		System.out.println(response.getHeader("content-type"));
		
		Assert.assertEquals(responseCode, 200);
	}
	
	@Test (priority = 2)
	public void Test2() {
			baseURI = "https://reqres.in/api";
			given().get("/users?page=2").then().statusCode(200).body("data[1].id",equalTo(8)).log().all();		
	
	//To print the full response body .log().all()
	}

	

	
	
	

}
