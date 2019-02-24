package com.epam.lab.businessObjects;

import com.epam.lab.elements.DraftPage;
import com.epam.lab.elements.HomePage;
import com.epam.lab.elements.MessageWindow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class MessageBO {

  private static final Logger LOG = LogManager.getLogger(MessageBO.class);
  private HomePage homePage;
  private MessageWindow messageWindow;
  private DraftPage draftPage;

  public MessageBO(WebDriver driver) {
    homePage = new HomePage(driver);
    messageWindow = new MessageWindow(driver);
    draftPage = new DraftPage(driver);
  }

  public void createMessageAndSave(String mailAdrress, String subject, String message) {
    homePage.openMailWindow();
    messageWindow.fillAddress(mailAdrress);
    messageWindow.fillSubject(subject);
    messageWindow.fillMessage(message);
    messageWindow.closeMailDraft();
  }

  public void openDraftMessageAndSend() {
    homePage.openDrafts();
    draftPage.openLastMailDraft();
    messageWindow.sendMail();
    homePage.sentMessageIdentifier();
  }

}
