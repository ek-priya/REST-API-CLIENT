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



#OUTPUT

![Image](https://github.com/user-attachments/assets/ebc88ed7-ca58-4231-bfaa-1ec7471c019d)
