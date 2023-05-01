package stepsDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pageobjects.ResultGoogleSearchPage;
import pageobjects.SearchGooglePage;
import restAssured.ApiWeather;

import static org.junit.Assert.assertEquals;
public class searchGoogleSteps {

    private WebDriver driver = new Hooks().getDriver();
    private ResultGoogleSearchPage resultGoogleSearchPage;
    private SearchGooglePage searchGooglePage;
    private ApiWeather apiWeather = new ApiWeather();
    double val1 = 0.0;
    @Given("the user open the web browser")
    public void the_user_open_the_web_browser() {
        searchGooglePage = new SearchGooglePage(driver);
        searchGooglePage.navigateWebpage();
    }
    @When("the user search {string}")
    public void the_user_search(String term) {
        resultGoogleSearchPage = searchGooglePage.searchText(term);
    }

    @When("the user search the latitude {string}, longitude {string}")
    public void the_user_search_the_latitude_longitude(String latitude, String longitude) {
        val1 = apiWeather.getWeatherEndpoint(Double.parseDouble(latitude),Double.parseDouble(longitude),"f55559f6fd1086226a7d022a124fb272");
    }

    @When("^the user search country \"([^\"]*)\"$")
    public void the_user_search_country(String country) {
        resultGoogleSearchPage = searchGooglePage.searchText(country + "temperature");
    }

    @Then("the temperature should be {string}")
    public void the_temperature_should_be(String valueTemp) {
        assertEquals(Integer.parseInt(valueTemp), (int)val1);
    }

    @Then("^the country temperature should be \"([^\"]*)\"$")
    public void the_country_temperature_should_be(String valueTemp) {
        int webValue = resultGoogleSearchPage.getTemperature().intValue();
        assertEquals(Integer.parseInt(valueTemp), webValue);
    }
}
