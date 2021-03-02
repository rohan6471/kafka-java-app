package edu.nwmissouri.bigdata.group6;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;
import java.util.Scanner;


public class SomaProducer{
	 private static Scanner in;

	  public static void main(String[] argv) throws Exception {
	    if (argv.length != 1) {
	      System.err.println("Please specify 1 parameter (the name of the topic)");
	      System.exit(-1);
	    }
	    String topicName = argv[0];
	    in = new Scanner(System.in);
	    System.out.println("Thank you for providing the topic " + topicName + "\n");
	    System.out.println("Enter message (type exit to quit).\n");

	    // Configure the Producer
	    Properties configProperties = new Properties();
	    configProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	    configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
	        "org.apache.kafka.common.serialization.ByteArraySerializer");
	    configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
	        "org.apache.kafka.common.serialization.StringSerializer");
	    System.out.println("The configuration properties are: " + configProperties.toString());
	    System.out.println("\nWill use this configuration to create a producer.\n");

	    org.apache.kafka.clients.producer.Producer producer = new KafkaProducer(configProperties);

	    
	    
	    for(int i=0;i<10;i++) {
	      String message = wordCount();
	      ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, message);
	      producer.send(record);
	   
	    }
	    // still allow input from keyboard
		String line = in.nextLine();
	    while (!line.equals("exit")) {
	      ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, line);
	      producer.send(rec);
	      line = in.nextLine();
	    }

	    in.close();
	    producer.close();

	  }
	  
	  private static String wordCount(){
		  String[] sentences = new String[] {
	              "beauty is in the eyes of the beer holders",
	              "Apple is not a fruit",
	              "Cucumber is not vegetable",
	              "Potato is stem vegetable, not root",
	              "Python is a language, not a reptile",
	              "To get something over with because it is inevitable",
	              "	The person we were just talking about showed up",
	              "What you have is worth more than what you might have later",
	              "To be mistaken, to be looking for solutions in the wrong place",
	              "Comparing two things that cannot be compared"
	          };   
		  
		  Random r = new Random();
	      // So we can generate random sentences
	      int num=r.nextInt(sentences.length);
	      String message=sentences[num];      
	      int count=0;  
	      char ch[]= new char[message.length()];     
	      for(int i=0;i<message.length();i++)  
	      {  
	          ch[i]= message.charAt(i);  
	          if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )  
	              count++;  
	      }  
	      
	      
	      return "For String ("+message+") word count is "+count;
	  }
}