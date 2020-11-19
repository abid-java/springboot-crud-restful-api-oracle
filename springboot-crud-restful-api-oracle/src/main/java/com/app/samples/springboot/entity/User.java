package com.app.samples.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

// TODO: Auto-generated Javadoc
/**
 * The Class User.
 */
@Entity
@Table(name="users")
public class User {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	/** The first name. */
	@NotNull
	@Size(min = 2, message = "First Name should have atleast 2 characters")
	@Column(name="first_name")
	private String firstName;
	
	/** The last name. */
	@NotNull
	@Size(min=2, message = "Last Name should have atleast 2 characters")
	@Column(name="last_name")
	private String lastName;
	
	/** The email. */
	@NotBlank
	@Email
	@Column(name="email")
	private String email;
	
	/**
	 * Instantiates a new user.
	 */
	public User() {
		super();
	}
	
	/**
	 * Instantiates a new user.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param email the email
	 */
	public User(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	

}