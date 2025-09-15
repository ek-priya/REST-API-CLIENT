# REST-API-CLIENT

*COMPANY*: CODTECH IT SOLUTIONS

*NAME*: EARLE KEERTHI PRIYA

*INTERN ID*: CT6WTKW

*DOMAIN*: JAVAPROGRMMING

*DURATION*: 6 WEEKS

*MENTOR*: NEELA SANTOSH

## WRITING A JAVA APPLICATION THAT CONSUMES  A PUBLIC REST API (E.G., FETCHING WEATHER  DATA) AND DISPLAYS THE DATA IN A  STRUCTURED FORMAT.


## API Reference

This project uses the OpenWeatherMap API to fetch real-time weather data based on the city name entered by the user.

#### API endpoint used

```http
 http://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}&units=metric

```
#### Required Parameters:


| Parameter | Type     | Description                                                     |
| --------- | -------- | --------------------------------------------------------------- |
| `q`       | `string` | **Required.** Name of the city (e.g., `London`, `Mumbai`)       |
| `appid`   | `string` | **Required.** Your API key from OpenWeatherMap                  |
| `units`   | `string` | **Optional.** Units of measurement (e.g., `metric`, `imperial`) |

#### Sample API call
```http
http://api.openweathermap.org/data/2.5/weather?q=Delhi&appid=YOUR_API_KEY&units=metric

```

## User Interface

- Users can input the city name in a text field.
- Upon clicking the **Search** button, the app fetches the data and displays:
  - **Location name**
  - **Temperature**
  - **Humidity**
  - **Description**
- Based on the description (e.g., haze, rain, clear), the background image updates dynamically to visually represent the weather.

---

##  Folder Structure

- WeatherApp.java   # Backend logic to fetch and process API data
- WeatherAppUI.java # User interface built with Java Swing
- pom.xml           # Maven configuration file with dependencies

---

## How to Run

1. Clone the repository:
   git clone https://github.com/ek-priya/REST-API-CLIENT.git

2. Navigate to the project directory:
   cd WeatherApp

3. Add your OpenWeatherMap API key in WeatherApp.java:
   private static final String API_KEY = "YOUR_API_KEY";

4. Build the project using Maven:
   mvn clean install

5. Run the application:
   mvn exec:java -Dexec.mainClass="api.WeatherAppUI"

#### Note 
Download jackson-databind-2.15.2.jar, jackson-core-2.15.2.jar, and jackson-annotations-2.15.2.jar files 

---
## OUTPUT

<img width="634" height="499" alt="Image" src="https://github.com/user-attachments/assets/4b2fe0f1-b9fc-4fea-a907-5eace0be1308" />
