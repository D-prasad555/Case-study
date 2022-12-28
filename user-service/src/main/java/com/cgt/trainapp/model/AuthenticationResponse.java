package com.cgt.trainapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {
	
	private String jwt;
	private String success;

	
}
