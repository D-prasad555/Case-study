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
@NoArgsConstructor


@Document(collection="ticket")
public class BookingModel {
	
	@Id
	private String pnrId;
	private String userId;
	private String name;
	private String phnnumber;
	private String email;
	private String trainNo;
	private String trainName;
	private String trainFrom;
	private String trainTo;
	private String date;
	private String time;
	private int totalseats;
	private int fare;
	
	
}
