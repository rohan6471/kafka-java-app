package edu.nwmissouri.bigdata.group6;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;
import java.util.Scanner;


public class KamalProducer{
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
	      String message = hashString();
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
	  
	  private static String hashString(){
		  String[] sentences = new String[] {
	              "Rohit sharma is my favorite cricketer",
	              "I love maryville",
	              "Cricket is not just a game it's an emotion",
	             "Doris enjoyed tapping her nails on the table to annoy everyone.",
"I think I will buy the red car, or I will lease the blue one.",
"He invested some skill points in Charisma and Strength.",
"There was coal in his stocking and he was thrilled.",
"He told us a very exciting adventure story.",
"The elephant didn't want to talk about the person in the room.",
"He is good at eating pickles and telling women about his emotional problems."}

	          };   
		  
		  Random r = new Random();
	      // So we can generate random sentences
	      int num=r.nextInt(10-1)+1;
	      int message=sentences[num].hashCode();      
	        
	      return "For String ("+sentences[num]+") hash code is '" + message+"'";
	  }
}