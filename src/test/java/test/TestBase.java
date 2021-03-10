package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import page.AuthPageStep;
import page.HomePageStep;
import page.crm.CRMPageStep;
import page.task.CreateTaskPageStep;
import page.task.popup.SelectUsersPopupStep;
import test.crm.Test1;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;
    public AuthPageStep authPageStep;
    public HomePageStep homePageStep;
    public CreateTaskPageStep createTaskPageStep;
    public SelectUsersPopupStep selectUsersPopupStep;
    public CRMPageStep crmPageStep;
    public Test1 test1;



    @BeforeEach
    public void start(){
        WebDriverManager.firefoxdriver().setup();
        WebDriverManager.chromedriver().setup();
        //ChromeOptions options = new ChromeOptions();
        //options.setHeadless(true);
        //driver = new ChromeDriver(options);
       //driver = new ChromeDriver();
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        authPageStep = PageFactory.initElements(driver, AuthPageStep.class);
        homePageStep = PageFactory.initElements(driver, HomePageStep.class);
        createTaskPageStep = PageFactory.initElements(driver, CreateTaskPageStep.class);
        selectUsersPopupStep = PageFactory.initElements(driver, SelectUsersPopupStep.class);
        crmPageStep = PageFactory.initElements(driver, CRMPageStep.class);
        test1 = PageFactory.initElements(driver, Test1.class);
    }

    @AfterEach
    public void finish(){
        driver.quit();
    }
}
