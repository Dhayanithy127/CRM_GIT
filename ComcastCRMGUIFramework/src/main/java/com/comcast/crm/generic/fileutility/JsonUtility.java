package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonUtility {
	public String getDataFromJsonFile(String key) throws IOException, ParseException {
		FileReader file=new FileReader("./configAppData/appCommonData.json");
		JSONParser p=new JSONParser();
		Object obj=p.parse(file);
		
		JSONObject map=(JSONObject)obj;
		String data=(String) map.get(key);
		return data;
		
	}

}
