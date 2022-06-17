package za.ac.cput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath*application-context.xml"})
public class SchoolManagementApplication {
public static void main(String[] args){

    SpringApplication.run(SchoolManagementApplication.class, args);

}

}
