package com.cgt.trainapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Document(collection="admindata")
public class AdminModel {
	
	@Id
	private String id;
	private String username;
	private String password;
	
	
}
