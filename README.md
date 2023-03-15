 
 
 
 
 CINEBOOKING APPLICATION:
    CineBooking is a Spring Boot application that allows users to book tickets for movies at various theaters. 
    It provides APIs for adding and updating user details, adding theaters and shows, booking and canceling tickets, and getting the location of theaters and getting show timings for movies and collections of movies.
    The application is integrated with Swagger for API documentation and testing, and uses JPA and Hibernate for database persistence.
     
GETTING STARTED:


  To get started with the CineBooking application, clone the repository to your local machine and import it into your IDE of choice. You will also need to have Java 11 and Maven installed on your machine.
  
  -> Next, configure the application's database connection by editing the application.properties file located in the src/main/resources directory. You will need to provide your database credentials and specify the database dialect.
  
  -> Once you have configured the database connection, build the application by running the following command in the terminal:mvn clean install.
  
  -> Once the build is successful, you can run the application by running the following command:mvn spring-boot:run
  The application will start up on port 8080.
  
  USAGE:
  To use the CineBooking APIs, open up the Swagger UI by navigating to http://localhost:8080/swagger-ui/index.html in your web browser. This will provide you with a list of all the available APIs.
  
  TECHNOLOGIES USED:
  SpringBoot,
  JPA Hibernate(MYSQL DB),
  Swagger.
  
