package test;
import io.qameta.allure.*;;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Test;


public class AuthPageTest extends TestBase {

    @Epic("TESTING FOR http://supervovan:8000/Security/Account/LogOn tasks")
    @Feature(value = "Tests authorization")
    @Severity(SeverityLevel.MINOR)
    @Story(value = "Sign in invalid login")
    @Description("Sign in invalid login")
    @Test
    public void signInvalidLogin(){
        authPageStep.goTo()
                    .fillLogin("admin1")
                    .fillPassword("1")
                    .clickBtnLogIn()
                    .errorMessage();
    }
    @Epic("TESTING FOR http://supervovan:8000/Security/Account/LogOn tasks")
    @Feature(value = "Tests authorization")
    @Story(value = "Sign in invalid password")
    @Description("Sign in invalid password")
    @Test
    public void signInvalidPassword(){
        authPageStep.goTo()
                    .fillLogin("admin")
                    .fillPassword("0")
                    .clickBtnLogIn()
                    .errorMessage();
    }
    @Epic("TESTING FOR http://supervovan:8000/Security/Account/LogOn tasks")
    @Feature(value = "Tests authorization")
    @Story(value = "Sign in valid login and password")
    @Description("Sign in valid login and password")
    @Test
    public void authorization(){
        authPageStep.goTo()
                .fillLogin("admin")
                .fillPassword("1")
                .clickBtnLogIn();
        homePageStep
                .welcomeMessage();
    }

    @Test
    public void createTask(){
        authPageStep.auth();
        homePageStep.clickBtnTask();
        homePageStep.clickBtnUser();
        //createTaskPageStep.clickBtnUser();
        selectUsersPopupStep.addUserSelectedItems();
    }

}
