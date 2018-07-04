package com.student.portal.loggin;

import java.util.logging.Filter;
import java.util.logging.LogRecord;

public class CustomFilter implements Filter {

	@Override
	public boolean isLoggable(LogRecord record) {
		if (record.getLevel().getName().equals("ALL")) {

			return false;

		}
		return true;

	}

}
