package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Абстрактные методы
 */
public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    // Метод "Ожидание появления элемента"
    public void waitVisibility(By elementBy){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }

    // Метод "Нажать на элемент"
    public void click(By elementBy){
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }

    /*//Write Text
    public void writeText(By elementBy, String text){
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }*/

    // Метод "Заполнить поле текстом"
    public void writeText(By elementBy, String text){
        waitVisibility(elementBy);
        WebElement element = driver.findElement(elementBy);
        element.clear();
        element.sendKeys(text);
    }

    // Метод "Получить текст со страницы"
    public String readText(By elementBy){
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }

    // Метод "Отображется ли элемента на странице"
    public void isElementDisplayed(By elementBy){
        waitVisibility(elementBy);
        assertTrue(driver.findElement(elementBy).isDisplayed());
    }

    // Метод "Не отображется ли элемента на странице"
    public void isElementNotDisplayed(By elementBy){
        assertFalse(driver.findElements(elementBy).size() > 0);
    }

    // Метод "Отображется ли алерт"
    public void isAlertText(String message){
        assertEquals(message, driver.switchTo().alert().getText());
    }

    // Метод "Заполнить поле текстом из случайных символов"
    public String writeRandomText(By elementBy, int lenght){
        waitVisibility(elementBy);
        WebElement element = driver.findElement(elementBy);
        element.clear();
        Random r = new Random();
        String rus = "абвгдеёжзийклмнопрстуфхцчъыьэюя";
        String eng = "abcdefghijklmnopqrstuvwxyz";
        String digit = "0123456789";
        String sum = rus + rus.toUpperCase() + eng + eng.toUpperCase() + digit;
        StringBuilder sb = new StringBuilder(lenght);
        for (int i = 0; i < lenght; i++)
            sb.append(sum.charAt(r.nextInt(sum.length())));
        element.sendKeys(sb);
        return sb.toString();
    }

    // Метод "Имитация нажатия на клавишу на клавиатуре"
    public static void pressButtonKeyboard(int event){
        try
        {
            Robot robot = new Robot();
            robot.keyPress(event);
            robot.keyRelease(event);
        }
        catch (Exception exp)
        {
            exp.printStackTrace();
        }
    }



}
