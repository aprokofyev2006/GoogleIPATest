package apitestrest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import utilitiesIPA.UtilsIPA;
import utilitiesIPA.RetryAnalyzer;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertEquals;

public class basics {
	Properties prop;
	FileInputStream file;
	
	@BeforeTest
	public void beforeTest() throws IOException{
		prop=new Properties();
		file = new FileInputStream("./src/test/resources/testdata/data.properties");
		prop.load(file);
	}
	
	@Test
	public void Test2(){
		int i=200;
		assertEquals(i, 200);
	}
	
	@Test//(retryAnalyzer = utilitiesIPA.RetryAnalyzer.class)
	public void Test(){
		
		RestAssured.baseURI=prop.getProperty("URI");
		
		Response resp=given().
		param("location","-33.8670522,151.1957362").
		param("radius","500").
		param("key",prop.getProperty("KEY")).log().all().
		when().get("/maps/api/place/nearbysearch/json").
		then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
		body("results[0].name",equalTo("Sydney")).and().
		body("results[0].place_id",equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM")).and().
		header("server","pablo").log().
		body().extract().response();
		
		JsonPath js=UtilsIPA.rowToJson(resp);
		int count=js.getInt("results.size()");
		for (int i=0;i<count;i++){
			System.out.println(js.get("results["+i+"].name"));
		}
		System.out.println(count);
		System.out.println(js.get("results[0].photos[0].height"));
		
//		System.out.println(resp.getTime());
//		System.out.println(resp.getStatusCode());
//		System.out.println(prop.getProperty("URI"));
//		System.out.println(prop.getProperty("KEY"));
	}

}
