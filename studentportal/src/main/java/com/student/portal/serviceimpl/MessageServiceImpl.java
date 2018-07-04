package com.student.portal.serviceimpl;

import com.student.portal.service.MessageServiceType;
import com.student.portal.service.MessageingService;

public class MessageServiceImpl implements MessageingService {
	private MessageServiceType email = null;

	public MessageServiceImpl() {}

	@Override
	public String sendMessage() {

		try {

			this.email.sendMessage();
			return SUCCESS;

		} catch (Exception e) {

			return FAILURE;

		}

	}

	@Override
	public void setMessageType(MessageServiceType email) {
		this.email = email;
	}

}
