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
import java.util.Scanner;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class WeatherApp {
   
   
    private static final String API_KEY = "API key";//get your api key from openweathermap
    

    @SuppressWarnings("CallToPrintStackTrace")
    public static void main(String[] args) {
        try {
            Scanner s=new Scanner(System.in);//to read input
            System.out.println("enter city name: ");
            //can enter any city name
            String CITY =s.nextLine();  //nextLine() takes String input from user
            String URL = "http://api.openweathermap.org/data/2.5/weather?q=" + CITY + "&appid=" + API_KEY + "&units=metric";

            // Make HTTP request
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .build();
                    //We use HttpRequest.newBuilder() to create a GET request to the weather API URL

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //send request using client.send().


            // Parse the JSON response
            ObjectMapper objectMapper = new ObjectMapper();//ObjectMapper from Jackson is used to parse the JSON response
            JsonNode rootNode = objectMapper.readTree(response.body());

            // Extract and display weather data
            if (rootNode != null) {
                JsonNode mainNode = rootNode.get("main");
                JsonNode weatherNode = rootNode.get("weather").get(0);
                
                if (mainNode != null && weatherNode != null) {
                    //extract the temperature, humidity, and weather description from the JSON structure.
                    double temperature = mainNode.get("temp").asDouble();
                    int humidity = mainNode.get("humidity").asInt();
                    String description = weatherNode.get("description").asText();

                    //displaying the extracted data 
                    System.out.println("Weather in " + CITY + ":");
                    System.out.println("Temperature: " + temperature + "°C");
                    System.out.println("Humidity: " + humidity + "%");
                    System.out.println("Description: " + description);
                }
            }
            s.close();//closes the scanner to prevent resource leak
        } catch (IOException | InterruptedException e)
        //adding exception handling to catch IO and Interrupted exceptions.
        {
            e.printStackTrace();
        }
    }
}

