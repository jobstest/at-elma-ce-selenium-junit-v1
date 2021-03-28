package page.task;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.BasePage;


/**
 * Шаги на странице "Создать задачу"
 */
public class CreateTaskPageStep extends BasePage {
    String CREATE_TASK_URL = "http://supervovan:8000/Tasks/Task/Create";

    public CreateTaskPageStep(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Открыть url")
    public CreateTaskPageStep goTo(){
        driver.get(CREATE_TASK_URL);
        return this;
    }

    @Step(value = "В поле Исполнитель нажать на кнопку Пользователь")
    public CreateTaskPageStep clickBtnUser(){
        click(By.xpath("//*[@id=\"TaskForm\"]/div/table/tbody/tr[2]/td[@class='captionCell']/following-sibling::td//img[@class='combobox-icon']"));
        return this;
    }

    @Step(value = "Заполнить поле Тема")
    public CreateTaskPageStep fillThemeRandom(int len){
        writeRandomText(By.id("Entity_Subject"), len);
        return this;
    }

    @Step(value = "Заполнить поле Исполнитель")
    public CreateTaskPageStep fillExecutor(String text){
        writeText(By.id("Executors_Id-input"), text);
        return this;
    }
    @Step(value = "Нажать на стрелку в поле Исполнитель")
    public CreateTaskPageStep clickSelectExecutor(){
        click(By.xpath("//*[@id=\"Executors_Id-input\"]//following-sibling::span[@class='t-select t-header combobox-first-icon']/span"));
        return this;
    }
    @Step(value = "Имитация нажатия на клавишу на клавиатуре")
    public CreateTaskPageStep clickEnterKeyboard(int event){
        pressButtonKeyboard(event);
        return this;
    }
    @Step(value = "Выбор из списка в поле Исполнитель")
    public CreateTaskPageStep selectFromDropDownListExecitor(String user){
        String listXpath = String.format("//*[@id=\"bodyelement\"]//div[contains(text(), '%s')]", user);
        driver.findElement(By.xpath(listXpath)).click();
        return this;
    }

}
