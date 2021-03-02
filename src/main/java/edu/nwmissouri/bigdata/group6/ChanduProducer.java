package edu.nwmissouri.bigdata.group6;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;
import java.util.Scanner;


public class ChanduProducer{
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

	    // Make our own messages - create your custom logic here
	    String msg="Multiplying two numbers!!";
	    ProducerRecord<String, String> record = new ProducerRecord<String, String>(topicName, msg);
	    producer.send(record);

	    for (int i = 1; i <= 10; i++) {
	      String message = multiplication();
	      ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, message);
	      producer.send(rec);
	    }

	    // still allow input from keyboard
		System.out.println("Multiplying two numbers");
	    String line = in.nextLine();
	    while (!line.equals("exit")) {
	      ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, multiplication1(line));
	      producer.send(rec);
	      line = in.nextLine();
	    }

	    in.close();
	    producer.close();

	  }

	 private static String multiplication() {

	        int[] num_multi= {1,23,32,12,33,23,14,44,43,17};
	        String str;
	    	Random r=new Random();
	    	int first_num=r.nextInt(50-10)+10;
	    	int second_num=r.nextInt(10-1)+1;
	    	int result= num_multi[first_num]*second_num;
	    		str="Multiplication successful, and the result is"+ result;
	    	return str;
	        }
		private static String multiplication1(String num) {
				 int user_num=Integer.parseInt(num);
	             String str;
	    	Random r=new Random();
	    	int number=r.nextInt(50-10)+10;
	    	int mutliplied_num=number*user_num;
	    		str="your result is"+mutliplied_num;
	    	return str;

	        }
	}