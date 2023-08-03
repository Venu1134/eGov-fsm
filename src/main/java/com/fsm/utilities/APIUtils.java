package com.fsm.utilities;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fsm.pojo.Assignee;
import com.fsm.pojo.Component;
import com.fsm.pojo.ContentChild;
import com.fsm.pojo.ContentParent;
import com.fsm.pojo.Description;
import com.fsm.pojo.Environment;
import com.fsm.pojo.Fields;
import com.fsm.pojo.Issuetype;
import com.fsm.pojo.Priority;
import com.fsm.pojo.Project;
import com.fsm.pojo.RequestPayload;

public class APIUtils {
	
	private static final  ObjectMapper mapper = new ObjectMapper();
	
	public static String  issueDescription ;
	
	public static final String frameJiraPayload(String issueSummary,String issueDescription) {
		
		RequestPayload jiraRequestPayload = new RequestPayload();
		Fields fields = new Fields();
		//assignee
		Assignee assignee = new Assignee();
		assignee.setAccountId("62d7cfa310c44eb6e32188ba");
		fields.setAssignee(assignee);
		//components
		Component component = new Component();
		component.setId("10008");
		ArrayList<Component> components = new ArrayList<>();
		components.add(component);
		fields.setComponents(components);
		//desc
		Description description = new Description();
		ContentChild contentChildDesc = new ContentChild();
		contentChildDesc.setText(issueDescription);
		contentChildDesc.setType("text");
		ArrayList <ContentChild> contentArrayListChildDesc = new ArrayList<ContentChild>();
		contentArrayListChildDesc.add(contentChildDesc);
		ContentParent contentParentDesc = new ContentParent();
		contentParentDesc.setContent(contentArrayListChildDesc);
		contentParentDesc.setType("paragraph");
		ArrayList <ContentParent> contentArrayListParentDesc = new ArrayList<ContentParent>();
		contentArrayListParentDesc.add(contentParentDesc);
		description.setContent(contentArrayListParentDesc);
		description.setType("doc");
		description.setVersion(1);
		fields.setDescription(description);
		//env
		Environment environment = new Environment();
		ContentChild contentChildEnv = new ContentChild();
		contentChildEnv.setText("UAT");
		contentChildEnv.setType("text");
		ArrayList <ContentChild> contentArrayListChildEnv = new ArrayList<ContentChild>();
		contentArrayListChildEnv.add(contentChildEnv);
		ContentParent contentParentEnv = new ContentParent();
		contentParentEnv.setContent(contentArrayListChildEnv);
		contentParentEnv.setType("paragraph");
		ArrayList <ContentParent> contentArrayListParentEnv = new ArrayList<ContentParent>();
		contentArrayListParentEnv.add(contentParentEnv);
		environment.setContent(contentArrayListParentEnv);
		environment.setType("doc");
		environment.setVersion(1);
		fields.setEnvironment(environment);
		//issueType
		Issuetype issuetype = new Issuetype();
		issuetype.setName("Bug");
		fields.setIssuetype(issuetype);
		//labels
		ArrayList<String> labels =  new ArrayList<>();
		labels.add("FunctionalAutomationDefect");
		fields.setLabels(labels);
		//priority
		Priority priority = new Priority();
		priority.setId("5");
		fields.setPriority(priority);
		//project
		Project project = new Project();
		project.setKey("CDP");
		fields.setProject(project);
		//summary
		fields.setSummary(issueSummary);
		jiraRequestPayload.setFields(fields);
		String jiraPayload = null;
		try {
			jiraPayload = mapper.writeValueAsString(jiraRequestPayload);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return jiraPayload;
	}

}
