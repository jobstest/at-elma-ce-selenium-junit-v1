package page.task;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import page.BasePage;


public class CreateTaskPageStep extends BasePage {
    String CREATE_TASK_URL = "http://supervovan:8000/Tasks/Task/Create";

    public CreateTaskPageStep(WebDriver driver) {
        super(driver);
    }

    @Step(value = "open url")
    public CreateTaskPageStep goTo(){
        driver.get(CREATE_TASK_URL);
        return this;
    }

    @Step(value = "Click btn User")
    public CreateTaskPageStep clickBtnUser(){
        click(By.xpath("//*[@id=\"TaskForm\"]/div/table/tbody/tr[2]/td[@class='captionCell']/following-sibling::td//img[@class='combobox-icon']"));
        return this;
    }





}
