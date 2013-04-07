package com.inspetion.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import android.util.Xml;

import com.inspetion.Entities.Command;

public class Tools {
	
	public static void sleep(long time){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static Command getCommandFromXML(File file,String name) {
	   Command command=null;
	   String commandName = null;
	   String tmp;
		 //absolute path:/data/data/com.inspection/files
       File xmlFile = new File(file,"commands.xml");
       
       if (name == null)
    	   throw new IllegalArgumentException();
       
       XmlPullParser parser = Xml.newPullParser();
       try {
			FileInputStream in = new FileInputStream(xmlFile);
			parser.setInput(in, "utf-8");
			
			int eventType = parser.getEventType();
			String tagName;
			while(eventType!= XmlPullParser.END_DOCUMENT){
				
				switch(eventType){
				case XmlPullParser.START_DOCUMENT:
					break;
				
				case XmlPullParser.START_TAG:
                   tagName = parser.getName();
                   if ("command".equals(tagName)){
                	   command = new Command();
                   }                  	
                   else if ("id".equals(tagName))
                       command.setId(parser.nextText());
                   else if ("start".equals(tagName))
                   	command.setStart(parser.nextText());
                   else if ("length".equals(tagName))
                   	command.setLength(parser.nextText());
                   else if ("end".equals(tagName))
                   	command.setEnd(parser.nextText());
                   else if ("receiveTime".equals(tagName))
                   	command.setReceiveTime(parser.nextText());
                   else if ("testName".equals(tagName)){
                	   tmp = parser.nextText();
                	   if (name.equals(tmp))
                	     command.setName(tmp);
                	   else{
                		   eventType = parser.next();                		   
                		   continue;
                		   }	                           	   
                	   
                   }                      	
					break;
					
				case XmlPullParser.END_TAG:

					break;

				
			}
				
				eventType = parser.next();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
       
       return command;
       
	}

}
