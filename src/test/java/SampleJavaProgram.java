import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleJavaProgram {

	public static void main(String[] args) {

		RestAssured.baseURI = "https://reqres.in";
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON); 
		//Adding Content type

		JSONObject requestParams = new JSONObject();

		requestParams.put("name", "weewRahil");
		requestParams.put("job", "Enewwegineer");

		request.body(requestParams.toJSONString());

		Response resp = request.request(Method.POST, "/api/users");

		resp.prettyPrint();

		System.out.println("Status code: " + resp.statusCode());

	}

}
