# Deliveroo

Parse CronString

Pre-Requisites:
Java 8/11
Maven

IDE:
IntelliJ

Overview:
ParseCronStringApplication was the main application class, which internally invoke ParseCronStringServiceImpl
 having business logic to calculate all the possible values for the each field in the cron string.

To build and execute the test cases:

mvn clean install

To Run the application:

mvn exec:java -Dexec.mainClass="com.deliveroo.ParseCronStringApplication" -Dexec.args=cronString

sample:

mvn exec:java -Dexec.mainClass="com.deliveroo.ParseCronStringApplication" -Dexec.args="*/15 0 1,15 * 1-5 /usr/bin/find"





