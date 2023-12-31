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
public class UserDTO {
	private Integer id;
	
	@NotNull
	@NotBlank
	private String username;
	
	@NotNull
	@NotBlank
	@Email
	private String email;
	
	@NotNull
	@NotBlank
	private String password;
	
//	@NotNull
//	@NotBlank
//	private String passwordConfirm;
	
//	@NotNull
//	@NotBlank
	private String photo;
	
	@NotNull
	private Integer admin;

	@NotNull
	private Integer activated;
}
