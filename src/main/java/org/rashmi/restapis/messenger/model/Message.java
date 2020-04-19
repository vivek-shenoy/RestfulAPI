package org.rashmi.restapis.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {

	private long ID;
	private String MSG;
	private String Author;
	private Date date;
	
	public Message() {
		
	}
	
	public Message(long msg_ID, String msg, String author ) {
		this.ID = msg_ID;
		this.MSG = msg;
		this.Author = author;
		this.date = new Date();
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getMSG() {
		return MSG;
	}

	public void setMSG(String mSG) {
		MSG = mSG;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
