package com.epam.lab.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

  private final By TABLIST_LOCATOR = By.xpath("//tr[@role='tablist']");

  @FindBy(xpath = "//div[@class='z0']")
  private WebElement buttonCompose;

  @FindBy(xpath = "//span[contains(text(), 'Message sent.')]")
  private WebElement sentMessageIdentifier;

  private WebDriver driver;

  public HomePage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  public void openMailWindow() {
    buttonCompose.click();
  }

  public void openDrafts() {
    driver.get("https://mail.google.com/mail/u/0/#drafts");
    new WebDriverWait(driver, 10)
        .until(ExpectedConditions.invisibilityOfElementLocated(TABLIST_LOCATOR));
  }

  public void sentMessageIdentifier() {
    new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(sentMessageIdentifier));
  }

}
