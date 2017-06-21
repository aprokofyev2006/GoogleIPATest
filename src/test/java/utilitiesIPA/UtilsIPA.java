package utilitiesIPA;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.path.xml.XmlPath;
import com.jayway.restassured.response.Response;

public class UtilsIPA {
	public static XmlPath rowToXml(Response resp){
		String response=resp.asString();
		XmlPath x=new XmlPath(response);
		return x;
	}
	
	public static JsonPath rowToJson(Response resp){
		String response=resp.asString();
		JsonPath x=new JsonPath(response);
		return x;
	}
}
