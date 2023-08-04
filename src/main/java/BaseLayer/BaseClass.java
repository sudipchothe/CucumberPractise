package BaseLayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

   


	public class BaseClass {
		
		protected static WebDriver driver;
		protected static Properties prop;
		static Statement stm;
		public Connection con;
		protected static RequestSpecification req;
		protected RequestSpecification httpRequest;
		protected Response resp;

	
		
		public  BaseClass ()  {
			prop = new Properties();
			try {
				FileInputStream fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\main\\java\\ConfigLayer\\config.properties");
				prop.load(fis);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void initlization(String browser) {
			String browser1 = prop.getProperty("browsername");

			if (browser1.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");

				driver = new ChromeDriver(options);
			}
			
			else if (browser1.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "\\Drivers\\msedgedriver.exe");
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--remote-allow-origins=*");
				driver = new EdgeDriver();
			} 
			
			
			
			else {
				System.err.println("Please Mention Validate browser name");
			}

			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
	  

			driver.get(prop.getProperty("url"));

		}
		
		public static void connectToDB() {
			try {
				Class.forName(prop.getProperty("DBConnection"));
				String url = prop.getProperty("DBurl");
				String username = prop.getProperty("DBusername");
				String password = prop.getProperty("DBpassword");
				Connection con = DriverManager.getConnection(url, username, password);
				stm = con.createStatement();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public static void retriveDateFromDB(String query) throws SQLException 
		{
			
			try {
				ResultSet rs = stm.executeQuery(query);

				int cols = rs.getMetaData().getColumnCount();

				rs.next();

				for (int i = 1; i <= cols; i++) {
					System.out.println(rs.getString(i));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		
		public static RequestSpecification requestSpecification() {
			RestAssured.baseURI = prop.getProperty("baseuri");
			
			if(req==null)
			{
				req = RestAssured.given().filter(RequestLoggingFilter.logRequestTo(logs("RequestLogs", "reqlogs")))
					.filter(ResponseLoggingFilter.logResponseTo(logs("ResponseLogs", "resplogs")))
					.contentType(ContentType.JSON)
					.header("Authorization","Bearer "+prop.getProperty("bearertoken"));
				return req;
			}		return req;
		}

		

		public static PrintStream logs(String foldername, String filename) {
			String date = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
			String path = System.getProperty("user.dir") + "//" + foldername + "//" + filename + date + ".txt";

			try {
				return new PrintStream(new FileOutputStream(path));
			} catch (FileNotFoundException e) {

				e.printStackTrace();
			}
			return null;
		}
		
		
		
}
