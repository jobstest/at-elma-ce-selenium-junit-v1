package page;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthPageStep extends BasePage{
    String SITE_URL = "http://localhost:8000/Security/Account/LogOn";
    public AuthPageStep(WebDriver driver) {
        super(driver);
    }

    @Step(value = "открыть url")
    public AuthPageStep goTo(){
        driver.get(SITE_URL);
        return this;
    }
    @Step(value = "Нажать на кнопку Войти в систему")
    public AuthPageStep clickBtnLogIn(){
        click(By.id("LogIn"));
        return this;
    }
    @Step(value = "Заполнить поле Имя пользователя")
    public AuthPageStep fillLogin(String login){
        writeText(By.id("login"), login);
        return this;
    }
    @Step(value = "Заполнить поле Пароль")
    public AuthPageStep fillPassword(String paswword){
        writeText(By.id("password"), paswword);
        return this;
    }
    @Step(value = "Сообщение - Неверное имя пользователя или пароль.")
    public AuthPageStep errorMessage(){
        isElementDisplayed(By.id("errorMessage"));
        return this;
    }

    @Step(value = "Авторизация под логином и паролем")
    public AuthPageStep auth(){
        goTo();
        fillLogin("admin");
        fillPassword("1");
        clickBtnLogIn();
        return this;
    }

}
