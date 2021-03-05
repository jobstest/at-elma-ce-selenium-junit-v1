package page;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthPageStep extends BasePage{
    String SITE_URL = "http://localhost:8000/Security/Account/LogOn";
    public AuthPageStep(WebDriver driver) {
        super(driver);
    }

    @Step(value = "open url")
    public AuthPageStep goTo(){
        driver.get(SITE_URL);
        return this;
    }
    @Step(value = "Click button LogIn")
    public AuthPageStep clickBtnLogIn(){
        click(By.id("LogIn"));
        return this;
    }
    @Step(value = "Fill in login with{0}")
    public AuthPageStep fillLogin(String login){
        writeText(By.id("login"), login);
        return this;
    }
    @Step(value = "Fill in password with{0}")
    public AuthPageStep fillPassword(String paswword){
        writeText(By.id("password"), paswword);
        return this;
    }
    @Step(value = "Sign in was unsccesful")
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
