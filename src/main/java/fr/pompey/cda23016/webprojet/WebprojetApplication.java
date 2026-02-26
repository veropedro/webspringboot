package fr.pompey.cda23016.webprojet;

import fr.pompey.cda23016.webprojet.config.CustomProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebprojetApplication {

    @Autowired
    private CustomProperties properties;

    public static void main(String[] args) {

        SpringApplication.run(WebprojetApplication.class, args);
    }

}
