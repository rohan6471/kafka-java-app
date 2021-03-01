package edu.nwmissouri.bigdata.group6;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.Random;
import java.util.Scanner;


public class PratapaProducer{
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
    String msg="Welcome to Number Guess Game!!";
    ProducerRecord<String, String> rec1 = new ProducerRecord<String, String>(topicName, msg);
    producer.send(rec1);

    for (int i = 1; i <= 10; i++) {
      String message = interest();
      ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, message);
      producer.send(rec);
    }

    // still allow input from keyboard
	System.out.println("Guess a number and lets check your luck");
    String line = in.nextLine();
    while (!line.equals("exit")) {
      ProducerRecord<String, String> rec = new ProducerRecord<String, String>(topicName, guessNumber1(line));
      producer.send(rec);
      line = in.nextLine();
    }

    in.close();
    producer.close();

  }
  public String interest(String value){
      int[] principal=[1400,13000,2500,1500,10000,2300,1100,54000,2560,2345];
  }
  
  
    public String interest1(String value){
int val=Integer.parseInt(value);
float p, r,  t; // principal amount, rate, time and simple interest respectively  
   r = 12; t = 2; 
   float interest = (val*r*t)/100;
   return ""+interest;
}
}



