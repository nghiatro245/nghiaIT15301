package com.it15301.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it15301.dto.UserDTO;
import com.it15301.entity.User;

@Service
public class UserMapper {
	@Autowired
	private ModelMapper modelMapper;
	
	public User convertToEntity(UserDTO dto) {
		User entity = modelMapper.map(dto, User.class);
		return entity;
	}
	
	public UserDTO convertToDTO(User entity) {
		UserDTO dto = modelMapper.map(entity, UserDTO.class);
		return dto;
	}
}
