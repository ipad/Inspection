package com.inspetion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

import com.inspetion.Entities.Command;
import com.inspetion.Entities.StartCommand;

import android.os.Bundle;
import android.util.Log;
import android.util.Xml;
import android.app.Activity;
import android.content.Intent;

public class IntroduceActivity extends Activity {
	public static final String TAG = "IntroduceActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_introduce);
		
		generateCommandsXML();		

		final Intent intent = new Intent(this, KaiJiZiJianActivity.class);

		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				startActivity(intent);
			}
		};
		timer.schedule(task, 3000);
	}

private boolean generateCommandsXML() {
		 //absolute path:/data/data/com.inspection/files
          File fileDir = getFilesDir();	
          File xmlFile = new File(fileDir,"commands.xml");
          Log.d(TAG, "xmlFile exist:"+xmlFile.exists());
          if (xmlFile.exists())
        	  return false;
          else{
        	  try {
				  xmlFile.createNewFile();
				  
		          List<Command> commands = new ArrayList<Command>();
		          Command startCommand = new StartCommand();
		          startCommand.setStart("7E");
		          startCommand.setEnd("7E");
		          startCommand.setId("04");
		          startCommand.setLength("04");
		          startCommand.setReceiveTime("90000");
		          startCommand.setName("startTesting");
		          
		          commands.add(startCommand);
		          
		          FileOutputStream out = new FileOutputStream(xmlFile);
		          buildXML(commands,out);
			} catch (IOException e) {
				e.printStackTrace();
				return false;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}              
          }
          
          return true;

	}
	
    public void buildXML(List<Command> commands,OutputStream outputStream)throws Exception{
	        XmlSerializer serializer = Xml.newSerializer();
	        serializer.setOutput(outputStream,"utf-8");
	        serializer.startDocument("utf-8", true);
	        serializer.startTag(null, "commands");
	        
	        for(Command command:commands){
	            serializer.startTag(null, "command");
	            
	            serializer.startTag(null, "testName");
	            serializer.text(command.getName());
	            serializer.endTag(null, "testName");
	            
	            serializer.startTag(null, "id");
	            serializer.text(command.getId());
	            serializer.endTag(null, "id");
	            
	             
	            serializer.startTag(null, "start");
	            serializer.text(command.getStart());
	            serializer.endTag(null, "start");
	             
	            serializer.startTag(null, "length");
	            serializer.text(command.getLength());
	            serializer.endTag(null, "length");
	            
	            serializer.startTag(null, "end");
	            serializer.text(command.getStart());
	            serializer.endTag(null, "end");
	            
	            serializer.startTag(null, "receiveTime");
	            serializer.text(command.getReceiveTime());
	            serializer.endTag(null, "receiveTime");
	 
	            serializer.endTag(null, "command");
	        }
	            
	        serializer.endTag(null, "commands");
	        serializer.endDocument();
	        outputStream.close();
	    }
}
