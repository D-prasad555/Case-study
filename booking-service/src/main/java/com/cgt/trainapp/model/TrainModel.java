package com.cgt.trainapp.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor


@Document(collection="trainsdata")
public class TrainModel {
	
	@Id
	public String trainNo;
	public String trainName;
	public String trainFrom;
	public String trainTo;
	public int fare;
	public int seats;
	public String time;
	
	
	
}
