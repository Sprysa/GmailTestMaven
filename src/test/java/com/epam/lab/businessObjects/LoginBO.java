package com.epam.lab.businessObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.epam.lab.elements.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginBO {

  private static final Logger LOG = LogManager.getLogger(LoginBO.class);
  private LoginPage loginPage;

  public LoginBO(WebDriver driver) {
    loginPage = new LoginPage(driver);
  }

  public void logIn(String email, String password) {
    loginPage.enterLogin(email);
    loginPage.submitLogin();
    loginPage.enterPassword(password);
    loginPage.submitPassword();
  }

}
