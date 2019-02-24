package com.epam.lab.elements;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessageWindow {

  @FindBy(className = "vO")
  private WebElement inputAddress;

  @FindBy(className = "aoT")
  private WebElement inputSubject;

  @FindBy(xpath = "//div[@class='Ar Au']//div[@role='textbox']")
  private WebElement inputMessage;

  @FindBy(className = "Ha")
  private WebElement closeEmail;

  @FindBy(xpath = "//div[@class='J-J5-Ji btA']//div[@role='button']")
  private WebElement buttonSendMail;

  private WebDriver driver;

  public MessageWindow(WebDriver driver) {
    PageFactory.initElements(driver, this);
    this.driver = driver;
  }

  public void fillAddress(String address) {
    inputAddress.sendKeys(address);
  }

  public void fillSubject(String subject) {
    inputSubject.sendKeys(subject);
  }

  public void fillMessage(String message) {
    inputMessage.sendKeys(message);
  }

  public void closeMailDraft() {
    new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(closeEmail)).click();
  }

  public void sendMail() {
    new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(buttonSendMail));
    clickWithJs(buttonSendMail);
  }

  private void clickWithJs(WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
  }

}
