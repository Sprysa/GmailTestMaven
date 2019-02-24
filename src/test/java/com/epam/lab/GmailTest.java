package com.epam.lab;

import com.epam.lab.businessObjects.LoginBO;
import com.epam.lab.businessObjects.MessageBO;
import com.epam.lab.drivers.DriverPool;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class GmailTest {

  private static final Logger LOG = LogManager.getLogger(GmailTest.class);
  private final String INITIAL_PAGE = "https://mail.google.com/";
  private final String LOGIN = "epam.test.sprysa@gmail.com";
  private final String PASSWORD = "die34nh2";
  private final String EMAIL_ADDRESS = "sprysa@gmail.com";
  private final String SUBJECT = "Test";
  private final String MESSAGE = "Hi from epam.test.sprysa@gmail.com";

  @BeforeMethod
  private void initializer() {
    System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    WebDriver driver = new ChromeDriver() {
      {
        manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
      }
    };
    driver.get(INITIAL_PAGE);
    DriverPool.setWebDriver(driver);
  }

  @DataProvider(name = "loginData", parallel = true)
  public Object[][] loginData() throws Exception {
    return new Object[][]{
        {LOGIN, PASSWORD}, {LOGIN, PASSWORD}, {LOGIN, PASSWORD},};
  }

  @Test(dataProvider = "loginData")
  public void testVariant2(String login, String password) {
    System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    WebDriver driver = DriverPool.getDriver();
    LoginBO loginbo = new LoginBO(driver);
    loginbo.logIn(login, password);
    MessageBO message = new MessageBO(driver);
    message.createMessageAndSave(EMAIL_ADDRESS, SUBJECT, MESSAGE);
    message.openDraftMessageAndSend();
    DriverPool.quit();
  }

}
