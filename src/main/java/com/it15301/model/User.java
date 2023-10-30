package com.it15301.model;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	private Integer id;
	
	private String name;
	
	private String studentCode;
	
	private String email;
	
	private String password;
	
	private String passwordConfirm;
	
	private Date dob;
	
	private String avatar;
	
	private Integer role;
	
	private Integer gender;
	
	private Integer status;
}
