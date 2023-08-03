package com.fsm.pojo;

import java.util.ArrayList;

public class Environment {
	public ArrayList<ContentParent> content;
    public String type;
    public int version;
    
	public ArrayList<ContentParent> getContent() {
		return content;
	}
	public void setContent(ArrayList<ContentParent> content) {
		this.content = content;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
}
