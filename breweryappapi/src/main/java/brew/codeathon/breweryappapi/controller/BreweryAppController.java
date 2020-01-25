package brew.codeathon.breweryappapi.controller;

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.*;

@RestController
@CrossOrigin
public class BreweryAppController {

    @Autowired
    RestTemplate restTemplate;

    String serviceURL = "http://api.brewerydb.com/v2/";
    String key = "/?key=5865f650b89955e6f423714b51a83354";

    @GetMapping("/list")
    public String getBreweryList() {
        return restTemplate.getForObject(serviceURL + "breweries" + key, String.class);
    }

    @GetMapping(value="/brewery/{id}")
    public String getBreweryById(@PathVariable("id") String id){
        return restTemplate.getForObject(serviceURL + "brewery/" + id + key, String.class);
    }

    @GetMapping(value="/beers/{id}")
    public String getBeersByBreweryId(@PathVariable("id") String id){
        return restTemplate.getForObject(serviceURL + "brewery/" + id  + "/beers" + key, String.class);
    }

    @GetMapping(value="/beer/{id}")
    public String getBeerInfoByBeerId(@PathVariable("id") String id){
        return restTemplate.getForObject(serviceURL + "beer/" + id + key, String.class);
    }

    @GetMapping(value="/ingredients/{id}")
    public String getIngredientsByBeerId(@PathVariable("id") String id){
        return restTemplate.getForObject(serviceURL + "beer/" + id + "/ingredients" + key, String.class);
    }

    @Bean
    public RestTemplate rest() {
        return new RestTemplate();
    }
}
