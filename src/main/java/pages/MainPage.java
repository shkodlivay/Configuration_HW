package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;


public class MainPage extends AbsBasePage{

    public MainPage(WebDriver driver) {
        super(driver, "");
    }

    public void inputText(String text) {
        WebElement textInput = driver.findElement(By.xpath("//*[@id=\"textInput\"]"));
        textInput.clear();
        textInput.sendKeys(text);
        String data=textInput.getAttribute("value");
        assertEquals(data, text);
    }

    public void clickOpenModal() {
        WebElement modalButton = driver.findElement(By.xpath("//*[@id=\"openModalBtn\"]"));
        modalButton.click();
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"myModal\"]")));
        } catch (TimeoutException e) {
            fail();
        }
    }

    public void inputName(String name) {
        WebElement nameInput = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        nameInput.clear();
        nameInput.sendKeys(name);
    }

    public void inputEmail(String email) {
        WebElement nameInput = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        nameInput.clear();
        nameInput.sendKeys(email);
    }

    public void clickButtonSend() {
        WebElement sendButton = driver.findElement(By.xpath("//*[@id=\"sampleForm\"]/button"));
        sendButton.click();
    }

}
