package brew.codeathon.breweryappapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class BreweryappapiApplication {

    public static void main(String[] args) {
        //SpringApplication.run(BreweryappapiApplication.class, args);
        SpringApplication app = new SpringApplication(BreweryappapiApplication.class);
        app.setDefaultProperties(Collections
                                         .singletonMap("server.port", "8083"));
        app.run(args);
    }

}
