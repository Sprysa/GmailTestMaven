package com.epam.lab.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

  @FindBy(xpath = "//input[@id='identifierId']")
  private WebElement inputLogin;

  @FindBy(id = "identifierNext")
  private WebElement buttonSendLogin;

  @FindBy(css = "input[type='password']:nth-child(1)")
  private WebElement inputPassword;

  @FindBy(id = "passwordNext")
  private WebElement buttonSendPassword;

  public LoginPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public void enterLogin(String email) {
    inputLogin.sendKeys(email);
  }

  public void submitLogin() {
    buttonSendLogin.click();
  }

  public void enterPassword(String password) {
    inputPassword.sendKeys(password);
  }

  public void submitPassword() {
    buttonSendPassword.click();
  }

}
