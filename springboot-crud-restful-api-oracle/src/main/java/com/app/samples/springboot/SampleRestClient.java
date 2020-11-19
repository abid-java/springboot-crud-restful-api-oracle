package com.app.samples.springboot;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.app.samples.springboot.entity.User;

// TODO: Auto-generated Javadoc
/**
 * The Class SampleRestClient.
 */
public class SampleRestClient {
	
	/** The Constant GET_ALL_USERS. */
	private static final String GET_ALL_USERS = "http://localhost:8080/api/users";
	
	/** The Constant GET_BY_USER_ID. */
	private static final String GET_BY_USER_ID = "http://localhost:8080/api/users/{id}";
	
	/** The Constant CREATE_USER. */
	private static final String CREATE_USER = "http://localhost:8080/api/users";
	
	/** The Constant UPDATE_USER. */
	private static final String UPDATE_USER = "http://localhost:8080/api/users/{id}";
	
	/** The Constant DELETE_USER. */
	private static final String DELETE_USER = "http://localhost:8080/api/users/{id}";
	
	/** The rest template. */
	static RestTemplate restTemplate = new RestTemplate();
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String args[]) {
		callGetAllUsers();
		callGetUserById();
		callCreateUser();
		callUpdateUser();
		callDeleteUser();
	}
	
	/**
	 * Call get all users.
	 */
	private static void callGetAllUsers() {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> httpEntity = new HttpEntity<>("parameters", httpHeaders);
		ResponseEntity<String> responseEntity = restTemplate.exchange(GET_ALL_USERS, HttpMethod.GET, httpEntity, String.class);
		System.out.println("Response : " + responseEntity);
	}
	
	/**
	 * Call get user by id.
	 */
	private static void callGetUserById() {
		Map<String, Integer> params = new HashMap<>();
		params.put("id", 3);
		
		User user = restTemplate.getForObject(GET_BY_USER_ID, User.class, params);
		
		if(user != null) {
			System.out.println("first name : " + user.getFirstName());
			System.out.println("last name : " + user.getLastName());
			System.out.println("email : " + user.getEmail());
		}		
	}
	
	/**
	 * Call create user.
	 */
	private static void callCreateUser() {
		User user = new User();
		user.setFirstName("nausheen");
		user.setLastName("sultana");
		user.setEmail("nausheen@gmail.com");
		
		ResponseEntity<User> newUser = restTemplate.postForEntity(CREATE_USER, user, User.class);
		user = newUser.getBody();	
	}
	
	/**
	 * Call update user.
	 */
	private static void callUpdateUser() {
		Map<String, Integer> params = new HashMap<>();
		params.put("id", 7);
		User updateUser = new User();
		updateUser.setFirstName("nhanni");
		updateUser.setLastName("amma");
		updateUser.setEmail("nhanni@gmail.com");
		 
		restTemplate.put(UPDATE_USER, updateUser, params);
	}
	
	/**
	 * Call delete user.
	 */
	private static void callDeleteUser() {
		Map<String, Integer> params = new HashMap<>();
		params.put("id", 6);
		restTemplate.delete(DELETE_USER, params);
	}
	

}
