package apiTest;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllProduct_testCases {

	@Test
	public void getViewCategory_antipyretic() {
		RestAssured.baseURI = "http://localhost:8082/medicare/json/data/category/1/products";
		
		RequestSpecification request = RestAssured.given(); // capturing the baseUrI in request object
		
		Response response = request.get();   //response is object of Response class, storing response from get request 
		
		String ResponseBody = response.getBody().asString(); //storing the get response as string in responseBody
		
		System.out.println(ResponseBody);
		
		int ResponseCode = response.getStatusCode(); //Fetching request's status Response status code
		
		Assert.assertEquals(ResponseCode,200);
		
		System.out.println("ResponseStatusCode : "+ResponseCode);
		
		JsonPath jpath  = response.jsonPath();  
		List <String> names  = jpath.get("name");
		
		System.out.println("Name of All Products");
		
		for (String i: names) {
			System.out.println(i);
		}
	}

}
