package com.fsm.pojo;

import java.util.ArrayList;

public class ContentParent {
	    public ArrayList<ContentChild> content;
	    public String type;
	    
		public ArrayList<ContentChild> getContent() {
			return content;
		}
		public void setContent(ArrayList<ContentChild> content) {
			this.content = content;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
}
