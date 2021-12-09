package dataProvider;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import managers.FileReaderManager;
import testDataTypes.loginPageData;



public class JsonDataReader {
	private final String oaoFirstPageFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath() + "testData.json";

	private List<loginPageData> oaodataList_firstPage;
	
	
	public JsonDataReader(){
		oaodataList_firstPage = getApplicantData_FirstPage();

	}
	
	private List<loginPageData> getApplicantData_FirstPage() {
		
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(oaoFirstPageFilePath));
			loginPageData[] Applicants = gson.fromJson(bufferReader, loginPageData[].class);
			
			return Arrays.asList(Applicants);
		}catch(FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + oaoFirstPageFilePath);
		}finally {
			try { if(bufferReader != null) bufferReader.close();}
			catch (IOException ignore) {}
		}
	}
	

}