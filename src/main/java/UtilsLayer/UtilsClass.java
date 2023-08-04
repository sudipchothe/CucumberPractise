package UtilsLayer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import BaseLayer.BaseClass;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UtilsClass extends BaseClass{

		static Response resp;
		static RequestSpecification httpRequest;

		public static String convertJavaToJson(Object obj) {
			ObjectMapper mapper = new ObjectMapper();
			String json = null;
			try {
				json = mapper.writeValueAsString(obj);
			} catch (JsonProcessingException e) {

				e.printStackTrace();
			}
			return json;
		}
		
		
		public static String captureValueFromRespBody(Response resp ,String key)
		{
			return resp.getBody().jsonPath().getString(key);	
		}
}
