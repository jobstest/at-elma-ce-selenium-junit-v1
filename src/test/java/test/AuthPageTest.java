package test;
import io.qameta.allure.*;;
import org.junit.jupiter.api.Test;

/**
 * Тесты на странице авторизации
 */
public class AuthPageTest extends TestBase {


    @Test
    @Description("Авторизация с неправильным логином")
    public void signInvalidLogin(){
        authPageStep.goTo()
                    .fillLogin("admin1")
                    .fillPassword("1")
                    .clickBtnLogIn()
                    .errorMessage();
    }


    @Test
    @Description("Авторизация с неправильным паролем")
    public void signInvalidPassword(){
        authPageStep.goTo()
                    .fillLogin("admin")
                    .fillPassword("0")
                    .clickBtnLogIn()
                    .errorMessage();
    }

    @Description("Авторизация через правильные логин и пароль")
    @Test
    public void authorization(){
        authPageStep.goTo()
                .fillLogin("admin")
                .fillPassword("1")
                .clickBtnLogIn();
        homePageStep
                .welcomeMessage();
    }

    /*@Test
    public void createTask(){
        authPageStep.auth();
        homePageStep.clickBtnTask();
        homePageStep.clickBtnUser();
        //createTaskPageStep.clickBtnUser();
        selectUsersPopupStep.addUserSelectedItems();
    }*/

}
