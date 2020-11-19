package com.app.samples.springboot.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.samples.springboot.repository.UserRepository;
import com.app.samples.springboot.entity.User;
import com.app.samples.springboot.exception.ResourceNotFoundException;

// TODO: Auto-generated Javadoc
/**
 * The Class UserController.
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

	/** The user repository. */
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	//get all users
	@GetMapping
	public List<User> getAllUsers() {
		return this.userRepository.findAll();
	}
	
	/**
	 * Gets the user by id.
	 *
	 * @param id the id
	 * @return the user by id
	 */
	//get user by Id
	@GetMapping("/{id}")
	public User getUserById(@PathVariable(value="id") long id) {
		return this.userRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("user not found with id : " + id));
		
	}
	
	/**
	 * Creates the user.
	 *
	 * @param user the user
	 * @return the user
	 */
	//create user
	@PostMapping
	public User createUser(@Valid @RequestBody User user) {
		return this.userRepository.save(user);
	}
	
	/**
	 * Update user.
	 *
	 * @param user the user
	 * @param userId the user id
	 * @return the user
	 */
	//update user
	@PutMapping("/{id}")
	public User updateUser(@Valid @RequestBody User user, @PathVariable("id") long userId) {
		User existingUser = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user not found with id : " + userId));
		if(user != null) {
			existingUser.setFirstName(user.getFirstName());
			existingUser.setLastName(user.getLastName());
			existingUser.setEmail(user.getEmail());
		}
		return this.userRepository.save(existingUser);
	}
	
	/**
	 * Delete user.
	 *
	 * @param userId the user id
	 * @return the response entity
	 */
	//delete user by Id
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") long userId) {
		User existingUser = this.userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user not found with id : " + userId));
		this.userRepository.delete(existingUser);
		return ResponseEntity.ok().build();
		
	}

}