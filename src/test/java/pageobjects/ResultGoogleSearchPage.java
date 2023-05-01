package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class ResultGoogleSearchPage {
    private WebDriver driver;
    private WebDriverWait wait;
    @FindBy(id = "wob_tm")
    private WebElement temperatureValue;

    public ResultGoogleSearchPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        initElements();
    }

    public void initElements(){
        PageFactory.initElements(driver,this);
    }
    public Integer getTemperature() {
        wait.until(ExpectedConditions.visibilityOf(temperatureValue));
        int tempValue = Integer.parseInt(temperatureValue.getText());
        return tempValue;
    }

}
