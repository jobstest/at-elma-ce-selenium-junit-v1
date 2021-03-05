package page;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePageStep extends BasePage{

    public HomePageStep(WebDriver driver) {
        super(driver);
    }

    @Step(value = "Sign in was succesful")
    public HomePageStep welcomeMessage(){
        isElementDisplayed(By.xpath("//*[@id=\"trPageHeader\"]/td/table/tbody/tr/td[1]/span"));
        //isElementDisplayed(By.xpath("//span[contains(text(), 'Добро пожаловать в систему ELMA!')]"));
        return this;
    }

    @Step(value = "Click button Task in toolbar")
    public HomePageStep clickBtnTask(){
        click(By.id("toolbar_btn_tasks_createtasktoobarbutton"));
        return this;
    }

    @Step(value = "Click btn User")
    public HomePageStep clickBtnUser(){
        click(By.xpath("//*[@id=\"TaskForm\"]/div/table/tbody/tr[5]/td[2]/div[2]/label/span"));
        return this;
    }

}
