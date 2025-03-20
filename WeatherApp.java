/*An API(Application Programming Interface) is a set of rules and protocols that 
allows different software applications to communicate and exchange data. It acts as a bridge, 
enabling applications to interact and share functionality, data, and services. 
an API that follows the principles of Representational State Transfer (REST), a software architectural style,
using standard HTTP methods to interact with data and resources.  */

package api;//defining package name

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class WeatherApp {
   
    private static final String API_KEY = "408761f5b1e4a80ba92a6e3a73a03b14";
    private static final String CITY ="texas";  
    private static final String URL = "http://api.openweathermap.org/data/2.5/weather?q=" + CITY + "&appid=" + API_KEY + "&units=metric";

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        try {
            // Make HTTP request
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Parse the JSON response
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(response.body());

            // Extract and display weather data
            if (rootNode != null) {
                JsonNode mainNode = rootNode.get("main");
                JsonNode weatherNode = rootNode.get("weather").get(0);
                
                if (mainNode != null && weatherNode != null) {
                    double temperature = mainNode.get("temp").asDouble();
                    int humidity = mainNode.get("humidity").asInt();
                    String description = weatherNode.get("description").asText();

                    System.out.println("Weather in " + CITY + ":");
                    System.out.println("Temperature: " + temperature + "°C");
                    System.out.println("Humidity: " + humidity + "%");
                    System.out.println("Description: " + description);
                }
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

