package crunchify.com.tutorials.pojo;

import java.io.Serializable;

public class User implements Serializable {
	
	String name = null;
	String fullName = null;
	
	public User() {
		name="My custom name";
		fullName = "My custom fullname";
	}
	

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public String getFullName() {
		// TODO Auto-generated method stub
		return fullName;
	}

}
