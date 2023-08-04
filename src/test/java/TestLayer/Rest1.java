package TestLayer;

import org.testng.annotations.Test;
import BaseLayer.BaseClass;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Rest1 extends BaseClass {

	@Test
	public void R1() {
		
	RequestSpecification httpRequest =   BaseClass.requestSpecification();
		Response resp = httpRequest.get();
		resp.prettyPrint();
	}
}
