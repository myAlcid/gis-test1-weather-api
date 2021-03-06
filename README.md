# weather-api
*Weather api is Api that can give you current weather and history of weather data from any location on Earth.*

## Configuration
To start working with such API you should configure `application.properties` file:

````
spring.datasource.url=jdbc:postgresql://ip:port/shema
spring.datasource.username=username
spring.datasource.password=password
````

## Examples 
This is the example how endpoints work:

#### Add new users in system
<details>
  <summary>POST localhost:8080/users/register</summary>
  
-------------------------------------  
Request body:
  
``` json
{
    "username":"username",
    "password": "password"
}
```

Response body:  
````
You successfully added user
````
-------------------------------------
</details>

#### Sign in to get your authorization token
<details>
  <summary>POST localhost:8080/users/login</summary>
  
-------------------------------------  
Request body:
  
``` json
{
    "username":"username",
    "password": "password"
}
```

Response body:  
````
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c2VybmFtZSIsImV4cCI6MTY1ODkxMzE5MiwiaWF0IjoxNjU4OTA5NTkyfQ.A1OKGBJwlPdaoAzj7DjdOepwMvTBr8tGO-kMr0_7ZFU
````
-------------------------------------
</details>

</details>

#### Add `city` in system
<details>
  <summary>POST localhost:8080/cities</summary>
  
-------------------------------------  
Request body:
  
``` json
{
    "name": "Chernivtsi",
    "longitude": 25.935837,
    "latitude": 48.292079
}
```

Response body:  
````json
{
    "id": 18,
    "name": "Chernivtsi",
    "longitude": 25.935837,
    "latitude": 48.292079
}
````
-------------------------------------
</details>

</details>

#### Find `city` by name
<details>
  <summary>GET localhost:8080/cities?city=Chernivtsi</summary>
  
-------------------------------------  

Request params:
- `city` - city name;

Response body:  
````json
{
    "id": 18,
    "name": "Chernivtsi",
    "longitude": 25.935837,
    "latitude": 48.292079
}
````
-------------------------------------
</details>

</details>

#### Get current `weather` by `city` name
<details>
  <summary>GET localhost:8080/weather/current?city=Lviv</summary>
  
-------------------------------------  

Headers:
````
Autorisation: Bearer {token-received-via-login-endpoint}
````

Request params:
- `city` - city name;

Response body:  
````json
{
    "temp": 20.58,
    "feelsLike": 20.42,
    "tempMin": 20.58,
    "tempMax": 20.58,
    "pressure": 1014.0,
    "humidity": 66.0,
    "windSpeed": 3.36,
    "windDegree": 307.0,
    "timestamp": 1658908801
}
````
-------------------------------------
</details>

</details>

#### Get `weather` history by `city` name and time period
<details>
  <summary>GET localhost:8080/weather/history?city=Lviv&from=1657814005&to=1658667602</summary>
  
-------------------------------------  

Headers:
````
Autorisation: Bearer {token-received-via-login-endpoint}
````

Request params:
- `city` - city name;
- `from` - timestamp of start date;
- `to` - timestamp of finish date.

Response body:  
````json
[
    {
        "temp": 24.96,
        "feelsLike": 25.0,
        "tempMin": 24.96,
        "tempMax": 24.96,
        "pressure": 1013.0,
        "humidity": 57.0,
        "windSpeed": 1.91,
        "windDegree": 295.0,
        "timestamp": 1657814363
    },
    {
        "temp": 23.17,
        "feelsLike": 23.34,
        "tempMin": 23.17,
        "tempMax": 23.17,
        "pressure": 1016.0,
        "humidity": 69.0,
        "windSpeed": 6.04,
        "windDegree": 315.0,
        "timestamp": 1658660316
    },
    {
        "temp": 23.24,
        "feelsLike": 23.24,
        "tempMin": 23.24,
        "tempMax": 23.24,
        "pressure": 1016.0,
        "humidity": 62.0,
        "windSpeed": 5.36,
        "windDegree": 321.0,
        "timestamp": 1658667391
    }
]
````
-------------------------------------
</details>
