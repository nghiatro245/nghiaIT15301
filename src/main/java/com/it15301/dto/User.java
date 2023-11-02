package com.it15301.dto;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Null
	private Integer id;
	
	@NotNull
	@NotBlank
	private String name;
	
	@NotNull
	@NotBlank
	private String studentCode;
	
	@NotNull
	@NotBlank
	@Email
	private String email;
	
	@NotNull
	@NotBlank
	private String password;
	
	@NotNull
	@NotBlank
	private String passwordConfirm;
	
	@NotNull
	private Date dob;
	
	@NotNull
	@NotBlank
	private String avatar;
	
	@NotNull
	private Integer role;
	
	@NotNull
	private Integer gender;
	
	@NotNull
	private Integer status;
}
