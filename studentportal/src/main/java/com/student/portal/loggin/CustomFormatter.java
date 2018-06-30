package com.student.portal.loggin;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class CustomFormatter extends Formatter {

	@Override
	public String format(LogRecord record) {
		return "[" + record.getLevel() + "] " + record.getLoggerName() + " " + new Date(record.getMillis()) + "::"
				+ record.getMessage()+"\n";
	}

}
