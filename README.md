# kafka-java-app

# Team Lead
### Rohan Bhandari -[https://github.com/rohan6471](https://github.com/rohan6471)
* I implemented a Custom Producer with a Number Guess Game which by default checks the array of 10 numbers with the system generated number in range 1 to 50.  
* If the number in the array matches with the generated number, you will win the game else you loose.   
* This producer also allows the user to enter a number from producer and try his luck to win the game.

### Commands for you to test your luck on Number Guess Game!! 

- Start the Zookeeper service from root folder where you installed kafka    
``` .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties ```   
- Start the Kafka service from root folder where you installed kafka  
``` .\bin\windows\kafka-server-start.bat .\config\server.properties ```  

Then Go to project root folder where your pom.xml files exists and run the below commands from administrator powershell    

- Compile and assemble the source code   
```mvn clean compile assembly:single ```  
- Start the Consumer     
```java -cp target/kafka-java-app-1.0-SNAPSHOT-jar-with-dependencies.jar edu.nwmissouri.bigdata.group6.Consumer test group1 ```  
- Start the Custom Producer     
```java -cp target/kafka-java-app-1.0-SNAPSHOT-jar-with-dependencies.jar edu.nwmissouri.bigdata.group6.RohanProducer test ```  



# Team Members

- Suma Soma -[Git hub Profile link](https://github.com/suma-gitrep)

* With my producer i tried to calculate the number of words for a string which is randomly selected.

### Commands to find the number of words in a randomly selected string!! 

- Start the Zookeeper service from root folder where you installed kafka    
``` .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties ```   
- Start the Kafka service from root folder where you installed kafka  
``` .\bin\windows\kafka-server-start.bat .\config\server.properties ```  

Then Go to project root folder where your pom.xml files exists and run the below commands from administrator powershell    

- Compile and assemble the source code   
```mvn clean compile assembly:single ```  
- Start the Consumer     
```java -cp target/kafka-java-app-1.0-SNAPSHOT-jar-with-dependencies.jar edu.nwmissouri.bigdata.group6.Consumer somatopic group1 ```  
- Start the Custom Producer     
```java -cp target/kafka-java-app-1.0-SNAPSHOT-jar-with-dependencies.jar edu.nwmissouri.bigdata.group6.SomaProducer somatopic ```  

- Neelesh Saladi- [My Github Profile](https://github.com/neeleshsaladi)
- Chandrakanth Polisetty - [GitHub profile](https://github.com/Chandupolisetty)
* I have worked on multiplying two numbers and show it on the cosumer console.
- Start the Consumer     
```java -cp target/kafka-java-app-1.0-SNAPSHOT-jar-with-dependencies.jar edu.nwmissouri.bigdata.group6.Consumer test group1 ```  

- Start the Custom Producer     
```java -cp target/kafka-java-app-1.0-SNAPSHOT-jar-with-dependencies.jar edu.nwmissouri.bigdata.group6.ChanduProducer test ```  


- Mohan Pratapa - [GitHub profile](https://github.com/mohanpratapa) 
* I have worked on calculating the simple interest for a set of given principle amounts and displayed it on the consumer console.

- To start the consumer
```java -cp target/kafka-java-app-1.0-SNAPSHOT-jar-with-dependencies.jar edu.nwmissouri.bigdata.group6.Consumer test group1 ``` 
- To start the producer
```java -cp target/kafka-java-app-1.0-SNAPSHOT-jar-with-dependencies.jar edu.nwmissouri.bigdata.group6.PratapaProducer test ```

- Kamal Reddy Donthireddy - [GitHub profile](https://github.com/Kamal4195) 
