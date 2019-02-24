package com.epam.lab.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DraftPage {

  @FindBy(xpath = "(//table[descendant::*[@jsaction]])[last()]//tr[@jsaction and contains(@class, 'zA')]//td[descendant::*[@data-thread-id]]")
  private WebElement openDraftEmail;

  public DraftPage(WebDriver driver) {
    PageFactory.initElements(driver, this);
  }

  public void openLastMailDraft() {
    openDraftEmail.click();
  }

}
