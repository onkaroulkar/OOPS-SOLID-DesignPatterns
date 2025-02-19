package org.onkar.DesignPattern.FacadePatternProblem;

// Microservice for User Management
public class UserService {
	
	public String getUserService(String userId) {
		return "user details for UserId: " + userId;
	}
}
