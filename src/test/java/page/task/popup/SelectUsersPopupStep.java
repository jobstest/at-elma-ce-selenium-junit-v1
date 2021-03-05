package page.task.popup;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import page.BasePage;

public class SelectUsersPopupStep extends BasePage {
    public SelectUsersPopupStep(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Перенести из 'Доступные элементы' в 'Выбранные элементы'")
    public SelectUsersPopupStep addUserSelectedItems(){
        WebElement userAvailableElements = driver.findElement(By.xpath("//*[@id=\"EntitySelectorExecutors_IdAvailableList\"]/li[4]/span/div/div[2]/div[1]"));
        WebElement selectedItems = driver.findElement(By.id("EntitySelectorExecutors_IdSelectedList"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(userAvailableElements, selectedItems).perform();

        isElementDisplayed(By.xpath("//*[@id=\"EntitySelectorExecutors_IdSelectedList\"]/li/span/div/div[2]/div[1]"));

        return  this;
    }


}
