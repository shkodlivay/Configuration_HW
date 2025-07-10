package main;

import factory.WebDriverFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import pages.MainPage;


public class MainPage_Test extends BaseSuite {
    protected static final Logger logger = LogManager.getLogger(MainPage_Test.class);

    @Test
    public void checkTextInput() {
        logger.info("Starting test checkTextInput");

        String text = "ОТУС";
        logger.debug("Test text to input: {}", text);

        driver = new WebDriverFactory().getDriver("headless");
        logger.debug("WebDriver initialized in headless mode");

        MainPage mainPage = new MainPage(driver);
        logger.debug("MainPage object created");

        mainPage.open();
        logger.info("Main page opened");

        mainPage.inputText(text);
        logger.info("Text '{}' input completed", text);

        logger.info("checkTextInput test completed successfully");
    }

    @Test
    public void checkModalWindow() {
        logger.info("Starting checkModalWindow test");
        
        driver = new WebDriverFactory().getDriver("kiosk");
        logger.debug("WebDriver initialized for kiosk mode");

        MainPage mainPage = new MainPage(driver);
        logger.debug("MainPage object created");

        mainPage.open();
        logger.info("Main page opened");

        mainPage.clickOpenModal();
        logger.info("Clicked on open modal button");

        logger.info("checkModalWindow test completed");
    }


    @Test
    public void checkMailForm() {
        logger.info("Starting checkMailForm test");

        String name = "Test_name";
        String email = "test@example.com";
        logger.debug("Test data - Name: {}, Email: {}", name, email);

        driver = new WebDriverFactory().getDriver("fullscreen");
        logger.debug("WebDriver initialized in fullscreen mode");

        MainPage mainPage = new MainPage(driver);
        logger.debug("MainPage object created");

        mainPage.open();
        logger.info("Main page opened successfully");

        mainPage.inputName(name);
        logger.info("Entered name: {}", name);

        mainPage.inputEmail(email);
        logger.info("Entered email: {}", email.replaceAll(".+@", "***@")); // Basic email masking

        mainPage.clickButtonSend();
        logger.info("Clicked send button");

        logger.info("checkMailForm test completed successfully");
    }

}
