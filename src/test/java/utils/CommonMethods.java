package utils;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.PageInitializer;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CommonMethods extends PageInitializer {
    public static WebDriver driver;
    public static void openBrowserAndLaunchApplication() {
        ConfigReader.readProperties(Constants.PATH);//made universal using Constant class for any machine
        switch (ConfigReader.getPropertyValue("browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup(); //resolves browser compatibility issue and set up the browser
                driver=new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid browser name");
        }
        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
       // driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT,TimeUnit.SECONDS);
        initializePageObjects();// method called from page initializer class


    }
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }

    }
    public static void sendText(WebElement element,String textToSend){ //overriding
        element.clear();
        element.sendKeys(textToSend);
    }

    public static WebDriverWait getWait(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds( Constants.EXPLICIT_WAIT));
        return wait;
    }


    public static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element){
        waitForClickability(element);
        element.click();
    }

    //alternative function for click(if above didn't work) and it will return JavascriptExecutor object
    public static JavascriptExecutor getJSExecutor(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        return js;
    }
    public static void jsClick(WebElement element){
        getJSExecutor().executeScript("arguments[0].click()",element);
    }



    /*
    public static void selectDropDown(WebElement element,String text){
        Select select=new Select(element);
        select.selectByVisibleText(text);
        //select.selectByValue("Married");
        //select.selectByIndex(3);  -- inplace of String text make, int text
    }
    public static byte[] takeScreenshotss(String filename) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        byte[] picBytes = ts.getScreenshotAs(OutputType.BYTES);

        try {
            String timestamp = getTimeStamp("yyyy-MM-dd-HH-mm-ss");
            File screenshotFile = new File(constants.SCREEN_SHOT_FILE_PATH + filename + " " + timestamp + ".png");
            FileUtils.writeByteArrayToFile(screenshotFile, picBytes);
            return picBytes;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getTimeStamp(String datePattern) {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
        return dateFormat.format(date);
    }*/
}