package com.student.portal.service;

public interface MessageingService {
	String SUCCESS = "Mail has been sent";
	String FAILURE = "Mail could not be sent";

	String sendMessage();

	void setMessageType(MessageServiceType email);
}
