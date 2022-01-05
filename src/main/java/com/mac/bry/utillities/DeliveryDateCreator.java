package com.mac.bry.utillities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DeliveryDateCreator {

	public String createDeliverDate(String donationDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dateTime = LocalDateTime.parse(donationDate, formatter);
		dateTime = dateTime.plusHours(3);
		return dateTime.format(formatter);
		
	}
}
