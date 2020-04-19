package org.rashmi.restapis.messenger.database;

import java.util.HashMap;
import java.util.Map;

import org.rashmi.restapis.messenger.model.Message;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();
	
	public static Map<Long, Message > getMessages () {
		return messages;
	}
	
}
