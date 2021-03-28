package test;

import io.qameta.allure.*;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.event.KeyEvent;


/**
 * Тесты на странице "Создать задачу"
 */
public class TasksTest extends TestBase{


    @Test
    @Description("Создать задачу")
    public void createTask(){
        authPageStep.auth();
        homePageStep.clickBtnTask();
        createTaskPageStep.fillThemeRandom(10)
                          .clickSelectExecutor()
                          .selectFromDropDownListExecitor("Администратор ELMA");




        //createTaskPageStep.clickBtnUser();
        //selectUsersPopupStep.addUserSelectedItems();
    }
}
