/**
 * 
 */
package com.inspetion.Entities;

/**
 * Abstract class definition for test commands.
 * @author jerry
 */
public class Command {
     protected String id;
	 protected String start;
	 protected String length;
	 protected String data;
	 protected String checkSum;
	 protected String end;
	 protected String receiveTime;
	 protected String name;
	 
	 	 
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

     public  void calulateCheckSum(){
		 
	 }
	 
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getStart() {
		return start;
	}
	
	public void setStart(String start) {
		this.start = start;
	}
	
	public String getLength() {
		return length;
	}
	
	public void setLength(String length) {
		this.length = length;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public String getCheckSum() {
		return checkSum;
	}
	
	public void setCheckSum(String checkSum) {
		this.checkSum = checkSum;
	}
	
	public String getEnd() {
		return end;
	}
	
	public void setEnd(String end) {
		this.end = end;
	}
	
	public String getReceiveTime() {
		return receiveTime;
	}
	
	public void setReceiveTime(String receiveTime) {
		this.receiveTime = receiveTime;
	}
	 

}
