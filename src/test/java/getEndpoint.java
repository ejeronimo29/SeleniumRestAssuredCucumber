import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;

public class getEndpoint {
    public static String tempWeather = "";

    @Parameters({"lat","lon","apik"})
    @Test
    public void getWeatherEndpoint(double lat, double lon, String apik){
        String baseUrl = "https://api.openweathermap.org";
        RestAssured.baseURI = baseUrl;

        double latitude = lat;
        double longitud = lon;
        String apikey = apik;

        Response response = given()
                .queryParam("lat", latitude)
                .queryParam("lon", longitud)
                .queryParam("appid",apikey)
                .when()
                .get("/data/2.5/weather")
                .then()
                .statusCode(200)  // Validate the status code is 200
                .body("size()", greaterThan(0))
                .extract().response();  // Ensure that I get a response with elements

        tempWeather = response.jsonPath().getString("main.temp"); // Extract the temperature value

    }

}
