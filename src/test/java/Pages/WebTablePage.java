package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebTablePage extends BasePage{

    By  tbActive = By.cssSelector("li[class=\"active\"] a");

    public String getActive(){
        return this.GetElement(tbActive, 10).getText();
    }
}
