package utils;


import org.openqa.selenium.*;

public class commonMethods {
    public static WebDriver driver;
    public static void openBrowserAndLaunchApplication() {
        ConfigReader.readProperties(Constants.PATH);//made universal using Constant class for any machine



        driver.manage().window().maximize();
       // driver.manage().timeouts().implicitlyWait(20,TimeUnit.Seconds);
       // driver.manage().timeouts().implicitlyWait(constants.IMPLICIT_WAIT,TimeUnit.Seconds);
       // driver.get(configReader.getPropertyValue("url"));
      //  pageObjectsInitializer();

    }
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
  /*  public static void sendText(WebElement element,String sendToText){
        element.clear();
        element.sendKeys(sendToText);
    }
    public static WebDriverWait getwait(){
        WebDriverWait wait=new WebDriverWait(driver,constants.EXPLICIT_WAIT);

        return wait;
    }
    public static void waitForClickability(WebElement element){
        getwait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void click(WebElement element){
        waitForClickability(element);
        element.click();
    }
    public static JavascriptExecutor getJavSript(){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        return js;
    }
    public static void jsClick(WebElement element){
        getJavSript().executeScript("arguments[0].click()",element);
    }
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