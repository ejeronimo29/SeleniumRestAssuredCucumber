
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.ResultGoogleSearchPage;
import pageobjects.SearchGooglePage;


public class testSearch {
    private WebDriver driver;
    private String baseUrl="http://www.google.com";
    String textSearch = "Weather in ";
    ResultGoogleSearchPage resultGoogleSearchPage= null;
    SearchGooglePage searchGooglePage = null;
    String tempWeather = "";
    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
    }
    @Parameters("country")
    @Test
    public void searchGoogle(String country){
        driver.get(baseUrl);
        searchGooglePage = new SearchGooglePage(driver);
        resultGoogleSearchPage = searchGooglePage.searchText(textSearch + country);
        double valueT = resultGoogleSearchPage.getTemperature();
        double TempEnd = Double.parseDouble(getEndpoint.tempWeather.toString().trim());
        System.out.println("Difference: " + (TempEnd-valueT));
        Assert.assertEquals(valueT,TempEnd);

    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
