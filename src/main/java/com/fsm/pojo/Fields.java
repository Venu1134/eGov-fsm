package com.fsm.pojo;

import java.util.ArrayList;

public class Fields {

	public Assignee assignee;
    public ArrayList<Component> components;
    public Description description;
    public Environment environment;
    public Issuetype issuetype;
    public ArrayList<String> labels;
    public Priority priority;
    public Project project;
    public String summary;
	public Assignee getAssignee() {
		return assignee;
	}
	public void setAssignee(Assignee assignee) {
		this.assignee = assignee;
	}
	public ArrayList<Component> getComponents() {
		return components;
	}
	public void setComponents(ArrayList<Component> components) {
		this.components = components;
	}
	public Description getDescription() {
		return description;
	}
	public void setDescription(Description description) {
		this.description = description;
	}
	public Environment getEnvironment() {
		return environment;
	}
	public void setEnvironment(Environment environment) {
		this.environment = environment;
	}
	public Issuetype getIssuetype() {
		return issuetype;
	}
	public void setIssuetype(Issuetype issuetype) {
		this.issuetype = issuetype;
	}
	public ArrayList<String> getLabels() {
		return labels;
	}
	public void setLabels(ArrayList<String> labels) {
		this.labels = labels;
	}
	public Priority getPriority() {
		return priority;
	}
	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
}
