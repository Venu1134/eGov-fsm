package com.fsm.jiraIntegration;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JiraOperations {

	String jiraURL = PropertiesOperations.getPropertyValueByKey("JiraURL");
	String jiraUserName = PropertiesOperations.getPropertyValueByKey("JiraUserName");
	String jiraAccessKey = PropertiesOperations.getPropertyValueByKey("JiraAccessToken");

	public String createJiraIssue(String jiraRequestPayload) throws ClientProtocolException, IOException, ParseException {
     
		String issueId = null; // to store bug id.
		System.out.println("Jira Pyload - "+ jiraRequestPayload);
		HttpClient httpClient = HttpClientBuilder.create().build();
		String url = jiraURL + "/rest/api/3/issue";
		HttpPost postRequest = new HttpPost(url);
		postRequest.addHeader("content-type", "application/json");
		String encoding = Base64.getEncoder().encodeToString((jiraUserName + ":" + jiraAccessKey).getBytes());
		postRequest.setHeader("Authorization", "Basic " + encoding);
		postRequest.setHeader("X-Atlassian-Token","nocheck");
		postRequest.setEntity(new StringEntity(jiraRequestPayload));
		HttpResponse response = httpClient.execute(postRequest);

		// convert httpresponse to string
		String jsonString = EntityUtils.toString(response.getEntity());
		System.out.println("jsonString : "+jsonString);

		// convert sring to Json
		JSONParser parser = new JSONParser();
		JSONObject json = (JSONObject) parser.parse(jsonString);
		issueId = (String) json.get("key");

		System.out.println("issueId : "+issueId);
		return issueId;

	}
	
	public void addAttachmentToJiraIssue(String issueId, String filePath) throws ClientProtocolException, IOException 
	{
		String pathname= filePath; 
		File fileUpload = new File(pathname);

		HttpClient httpClient = HttpClientBuilder.create().build();
		String url = jiraURL+"/rest/api/3/issue/"+issueId+"/attachments";
		HttpPost postRequest = new HttpPost(url);

		String encoding = Base64.getEncoder().encodeToString((jiraUserName+":"+jiraAccessKey).getBytes());

		postRequest.setHeader("Authorization", "Basic " + encoding);
		postRequest.setHeader("X-Atlassian-Token","nocheck");

		MultipartEntityBuilder entity=MultipartEntityBuilder.create();
		entity.addPart("file", new FileBody(fileUpload));
		postRequest.setEntity( entity.build());
		HttpResponse response = httpClient.execute(postRequest);
		System.out.println(response.getStatusLine());

		if(response.getStatusLine().toString().contains("200 OK")){
			System.out.println("Attachment uploaded");
		} else{
			System.out.println("Attachment not uploaded");
		}
	}
}
