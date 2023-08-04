package UtilsLayer;


	import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BaseLayer.BaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;
import io.restassured.specification.RequestSpecification;

	public class RestAssuredExtentReportExample1 extends BaseClass {
	    private ExtentReports extent;
	    private ExtentTest test;

	    @Test
	    public void exampleTest() {
	        extent = new ExtentReports();
	        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extent-report.html");
	        htmlReporter.config().setTheme(Theme.DARK);  // Set report theme (optional)
	        extent.attachReporter(htmlReporter);
	        test = extent.createTest("Example Test");

	        // Make an API request
	        RequestSpecification request = RestAssured.given();
	        Response response = request.get("http://localhost:3000/posts");

	        // Capture request and response logs
	      //  String requestLogs = request.log().all();
	        String responseLogs = response.then().log().all().extract().asString();

	        // Attach logs to Extent Report test node
	//        test.info("Request Logs:\n" + requestLogs);
	        test.info("Response Logs:\n" + responseLogs);

	      
	        extent.flush();
	    }
	}


