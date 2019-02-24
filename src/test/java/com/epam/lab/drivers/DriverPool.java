package com.epam.lab.drivers;

import org.openqa.selenium.WebDriver;

public class DriverPool {

  private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();

  public static WebDriver getDriver() {
    return webDriver.get();
  }

  public static void setWebDriver(WebDriver driver) {
    webDriver.set(driver);
  }

  public static void quit() { webDriver.get().quit(); }
}
