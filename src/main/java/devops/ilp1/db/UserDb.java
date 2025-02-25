package devops.ilp1.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import devops.ilp1.model.User;

public class UserDb {
	
	public static String[][] users;
	public static List<User>  usersData;
	
	public static Map<String, User> userProfile=new HashMap<String,User>();
	
	public UserDb(){
		
		User u1=new User("A","P","1234","a.p@devops.com");
		User u2=new User("P","R","abcd","p.r@devops.com");
		User u3=new User("R","S","pqrs","r.s@devops.com");
	
		
		userProfile.put(u1.getEmail(), u1);
		userProfile.put(u2.getEmail(), u2);
		userProfile.put(u3.getEmail(), u3);
		
	}
	


}
