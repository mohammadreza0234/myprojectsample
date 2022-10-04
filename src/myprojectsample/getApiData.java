package myprojectsample;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getApiData {

	
	
	
	public static void main(String[] args) {
	
		RestAssured.baseURI = "https://randomuser.me";
		
		RequestSpecification getData = RestAssured.given().header("Content-Type","application/json");
		
		Response response = getData.when().get("/api");
		
		response.prettyPrint();
		

	}

}
