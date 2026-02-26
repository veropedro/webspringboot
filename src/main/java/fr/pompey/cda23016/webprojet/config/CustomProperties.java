package fr.pompey.cda23016.webprojet.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "fr.pompey.cda23016.webprojet")
@Data
public class CustomProperties {

    private String urlAPI;

}
