package org.rashmi.restapis.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.rashmi.restapis.messenger.database.DatabaseClass;
import org.rashmi.restapis.messenger.model.Message;

public class MessageService {

	private Map<Long, Message> Messages = DatabaseClass.getMessages();

	public MessageService () {
		Messages.put(1L,new Message(1L,"First Message", "Vivek"));
		Messages.put(2L,new Message(2L,"Second Message", "Rashmi"));
	}

	public List<Message> getAllMessages(){
		/*Message M1 = new Message(1L,"First Message", "Vivek");
		Message M2 = new Message(1L,"Second Message", "Rashmi");
		List<Message> list = new ArrayList<>();
		list.add(M1);
		list.add(M2);
		return list;*/
		return new ArrayList<Message>(Messages.values());
	}

	public Message getMessage(Long id) {
		return Messages.get(id);
	}

	public Message addMessage(Message msg) {
		Long iD = (long) (Messages.size()+1);
		msg.setID(iD);
		Messages.put(iD, msg);
		return msg;
	}

	public Message updateMessage(Long ID, Message msg) {
		msg.setID(ID);
		Messages.put(ID, msg);
		return msg;
	}

	public Message updateAuthor(Long ID, String author) {
		Message msg = Messages.get(ID);
		msg.setAuthor(author);
		Messages.replace(ID, msg);
		return msg;
	}
	
	public Message deleteMessage(Long id) {
		return Messages.remove(id);
	}

}
