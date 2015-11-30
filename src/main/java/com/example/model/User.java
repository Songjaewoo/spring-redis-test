package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.ser.std.SerializableSerializer;

import lombok.Data;

@Data
@Entity
public class User extends SerializableSerializer {

	private static final long serialVersionUID = 8079794109778366251L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	private String nickname;
}
