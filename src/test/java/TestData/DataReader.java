package TestData;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	public List<HashMap<String, String>> getJsonData() throws IOException {
		
		//read json to string
		String jsonContent = FileUtils.readFileToString(new File( System.getProperty("user.dir")+ "//src//test//java//TestData//PurchaseOrderData.json"));
		
		//	String to Hashmap  and also adding Jackson databid
			
		ObjectMapper object = new ObjectMapper();
		List<HashMap<String,String>> data = object.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>( ){});
		
		return data;
	}
	
}
