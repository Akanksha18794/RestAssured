import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class DeleteRequest {

	
	@Test
	public void Deleterequest() {
		
		baseURI = "https://reqres.in";
	
		when().delete("/api/users/2").then().statusCode(204).log().all();
}
	}

