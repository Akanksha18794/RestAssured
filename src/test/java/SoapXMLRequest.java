import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.equalTo;

public class SoapXMLRequest {
	
	@Test
	public void ValidateSoapXML() throws IOException {
		
		File file = new File ("./SoapRequest/Add.xml.txt");
		
		if(file.exists())
			System.out.println("File Exists");
		
		FileInputStream ip = new FileInputStream(file);
		String requestBody = IOUtils.toString(ip, "UTF-8");
		
		baseURI = "http://dneonline.com/";
		given().
		contentType("text/xml").
		accept(ContentType.XML).
		body(requestBody).when().
		post("/calculator.asmx").
		then().statusCode(200).log().all().and().body("//*:AddResult.text()",equalTo("30"));
	}
}
