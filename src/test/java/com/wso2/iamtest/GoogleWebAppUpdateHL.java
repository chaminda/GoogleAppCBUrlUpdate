/**
 * @Author: chaminda@wso2.com
 * @Status: In-progress
 */
package com.wso2.iamtest;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.PrintWriter;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class GoogleWebAppUpdateHL {
  private WebDriver driver;
  //private HtmlUnitDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new HtmlUnitDriver(BrowserVersion.CHROME, true);
    baseUrl = "https://console.developers.google.com";
    //driver.setJavascriptEnabled(true);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Parameters({"username","password","callbackUrl", "clientAppName"})
  @Test
  public void testUntitledTestCase(String username, String password, String callbackUrl, String clientAppName) throws Exception {
    driver.get(baseUrl+"/");
    driver.findElement(By.id("identifierId")).clear();
    driver.findElement(By.id("identifierId")).sendKeys(username);
    if(driver.findElement(By.id("identifierNext")).isDisplayed()){
      System.out.println("VISBLE-========");
    }
    WebElement link = driver.findElement(By.id("identifierId"));
    Actions builder = new Actions(driver);
    builder.moveToElement(link).click().perform();
    builder.sendKeys(Keys.ENTER).perform();
    builder.release().perform();

    //driver.switchTo().activeElement().sendKeys(Keys.ENTER);
    //Robot rbt = new Robot();
    //rbt.keyPress(KeyEvent.VK_R);
    //rbt.keyRelease(KeyEvent.VK_R);
    //((JavascriptExecutor)driver).executeScript("document.getElementById('identifierNext').click()");

    //((JavascriptExecutor)driver).executeScript(mouseOverScript, link);
    //((JavascriptExecutor)driver).executeScript(onClickScript, link);
    //JavascriptExecutor executor = (JavascriptExecutor)driver;
    //executor.executeScript("arguments[0].click();", link);
    //executor.executeScript("window.document.getElementById('identifierId').click()");
    //executor.executeScript("var elem=arguments[0]; setTimeout(function() {elem.click();}, 100)", link);


    //System.out.print("URL :" + driver.getPageSource().toString());
    //PrintWriter out = new PrintWriter("filename.txt");

    //driver.findElement(By.xpath("//span[text()='Next']")).click();
    //out.println(driver.getPageSource().toString());
    Thread.sleep(5000);
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys(password);
    driver.findElement(By.xpath("//div[@id='passwordNext']/content/span")).click();
    driver.findElement(By.xpath("//a[@id='p6ntest-vulcan-leftnav-credentials']/span")).click();
    driver.findElement(By.linkText("Web client 2")).click();
    Thread.sleep(3000);
    builder.sendKeys(Keys.TAB).perform();
    builder.sendKeys(Keys.TAB).perform();
    builder.sendKeys(Keys.DELETE).perform();
    WebElement elm = driver.switchTo().activeElement();
    elm.sendKeys("http://localhost:8080/selenium");
    builder.sendKeys(Keys.ENTER).perform();
    builder.sendKeys(Keys.TAB).perform();
    builder.sendKeys(Keys.ENTER).perform();
    //if(driver.findElement(By.xpath("span[text()='http://localhost:8080/new']")).isDisplayed()){
    // System.out.println("TestValsu===");
    //}
    //driver.findElement(By.xpath("//fieldset[2]/div/div/ng-form/ul/li/span")).click();
    //driver.findElement(By.xpath("//fieldset[2]/div/div/ng-form/ul/li/span")).clear();
    //driver.findElement(By.xpath("//fieldset[2]/div/div/ng-form/ul/li/span")).sendKeys("http://localhost:8080/selenium");
    Thread.sleep(5000);
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
