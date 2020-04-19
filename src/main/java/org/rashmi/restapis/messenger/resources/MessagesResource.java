package org.rashmi.restapis.messenger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.rashmi.restapis.messenger.model.Message;
import org.rashmi.restapis.messenger.service.MessageService;

@Path("/messages")
public class MessagesResource {

	//private List<Message> MSG;
	static MessageService service;
	static boolean isInitialised = false;
	
	public MessagesResource() {
		if(!isInitialised) {
			service = new MessageService();
			isInitialised = true;
		}
	}
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Message> GetMessages() {
		//MessageService service = new MessageService();
		//MSG = service.getAllMessages();
		//return MSG;
		return service.getAllMessages();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{messageid}")
	public Message getMessage(@PathParam("messageid") Long id) {
		return service.getMessage(id);
	}
	
	//public Message addMessage( Message msg) {
	//	return service.addMessage(msg);
	//}
	
	@POST	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message addMessage( Message msg) {
			return service.addMessage(msg);
	}
	
	@Path("/{messageid}")
	@PUT	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage( @PathParam("messageid") Long id, Message msg) {
			return service.updateMessage(id,msg);
	}
	
	@Path("/{messageid}/{author}")
	@PUT	
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateName( @PathParam("messageid") Long id, @PathParam("author") String author) {
			return service.updateAuthor(id,author);
	}
	
	@Path("/{messageid}")
	@DELETE	
	@Produces(MediaType.APPLICATION_JSON)
	public Message delMessage( @PathParam("messageid") Long id) {
			return service.deleteMessage(id);
	}
}
