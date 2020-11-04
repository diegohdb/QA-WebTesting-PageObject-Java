package Pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;

public class BasePage {

    public static WebDriver driver;

    public static void webConnection(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
        options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
        options.addArguments("--headless"); // only if you are ACTUALLY running headless
        options.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
        options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
        options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
        options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
        options.addArguments("--disable-gpu"); //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc
        driver = new ChromeDriver(options);
    }

    public static void closeBrowser(){
        driver.quit();
    }

    public void Visit(String url){
        driver.get(url);
    }

    public WebElement GetElement(By by_locator, int waitfor){
        WebDriverWait wait = new WebDriverWait(driver, waitfor);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by_locator));
    }


    public List<WebElement> GetElements(By by_locator, int waitfor){
        WebDriverWait wait = new WebDriverWait(driver, waitfor);
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by_locator));
    }

    public void SendText(By by_locator, String text){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by_locator)).sendKeys(text);
    }

    public void Click(By by_locator){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(by_locator)).click();
    }

    public void HoverTo(By hoverElement){
        Actions builder = new Actions(driver);
        builder.moveToElement(GetElement(hoverElement, 10)).perform();
    }

    public void Select(By by_locator, String value){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(by_locator)));
//        dropdown.selectByVisibleText(value);
//        dropdown.selectByIndex(1);
        dropdown.selectByValue(value);
    }

    public void SelectByLi(By by_locator, String value){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Click(by_locator);
        String li_locator = "//a[text()=\""+value+"\"]";
        Click(By.xpath(li_locator));
    }

    public void SelectAutoComplete(By by_locator, By by_locator2, By by_locator3, String value){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Click(by_locator);
//        Select dropdown = new Select(wait.until(ExpectedConditions.visibilityOfElementLocated(by_locator)));
        SendText(by_locator2, value);
        Click(by_locator3);
    }

    public String GetValidationMessage(By by_locator){
        WebElement element = this.GetElement(by_locator, 10);
        return element.getAttribute("validationMessage");
    }

    public void DeleteByIndex(int index){
        String locator = "/html/body/div[2]/div/ul/li["+index+"]/a";
        By by_locator = By.xpath(locator);
        Click(by_locator);
    }

    public void ClickProductByIndex(int index){
        String locator = "/html/body/div[2]/div/ul/li["+index+"]/span/a";
        By by_locator = By.xpath(locator);
        Click(by_locator);
    }
}
