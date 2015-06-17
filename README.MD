# SpringBootExample
Sample Spring boot application developed using Spring Boot, Hibernate ORM, H2 inMemory datastore.<br/>
Fallowed Spirng Boot convention over configuration.

#Tech Stack.
  1. <a href="http://projects.spring.io/spring-boot/">Spring Boot.</a>
  2. <a href="http://hibernate.org/orm/" >HibernateORM. </a>
  3. <a href="http://www.h2database.com/html/main.html">H2 Datastore.</a>
  4. <a href="https://gradle.org/">Gradle</a>

#Prerequisites.
 JDK 7 or above. <br/>
 Gradle (for installation refer https://docs.gradle.org/current/userguide/installation.html)  

#Configuration.
 If you would like change the datastore, make necessary changes to application.properties file and add relevant jar in 
 the dependency section of build.gradle.
#How to Import into IDE?
 
 Used gradle build tool as dependency management, build and packaging. Go to the cloned/downloaded directory and run the below task.

1. For eclipse lovers.

 >gradlew eclipse 
 
 The above task generates two new files .eclipse and .project under root directory. Now you should be able import the project.

2. For running test cases from command tool window.
 >gradlew test
 
  This task builds the application and start up  the server on default port no 8080, you can change it through application.properties have a look.

3. For packaging to deliver.
 >gradlew build
  
  After successful ./build/interviewer.zip file can be found. To run this directly unzip it you can find ./bin/*.bat windows bat file start the server, befor run it do below modification for only windows users.

Replace entire CLASSPATH setting with the "set CLASSPATH=%APP_HOME%\conf;%APP_HOME%\lib\*;" . Since windows has limitation in classpath setting.
This is bug in gradle https://issues.gradle.org/browse/GRADLE-2992 .

#Known Issues and Limitation.
 1. .bat has to be modify manually prior to run.
