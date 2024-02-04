package com.csc340.csc340Assignment2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Csc340Assignment2Application {

    public static void main(String[] args) {
        SpringApplication.run(Csc340Assignment2Application.class, args);
        System.out.print("\n\n");
        getActivity();
        System.exit(0);
    }

    public static void getActivity() {
        try {
            String url = "https://www.boredapi.com/api/activity";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jSonFact = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jSonFact);

            String activity = root.findValue("activity").asText();
            String type = root.findValue("type").asText();

            System.out.println("**********Your Random Activity********");
            System.out.println("Activity: " + activity);
            System.out.println("Type of activity: " + type);

        } catch (JsonProcessingException ex) {
            Logger.getLogger(Csc340Assignment2Application.class.getName()).log(
                    Level.SEVERE,
                    null, ex);
            System.out.println("error in getActivity");

        }
    }
}
