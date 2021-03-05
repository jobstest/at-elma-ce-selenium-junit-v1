package page.crm;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import page.BasePage;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class CRMPageStep extends BasePage {
    String CRM_URL = "http://localhost:8000/CRM";
    public CRMPageStep(WebDriver driver) {
        super(driver);
    }

    @Step
    public CRMPageStep goTo(){
        driver.get(CRM_URL);
        return this;
    }

    @Step("Проверяем текст в в списке Тип объектов")
    public CRMPageStep textSelectTypeObject() {
        Select select = new Select(driver.findElement(By.xpath("//*[@id=\"DataFilter_Filter_ObjectsType_ValueContainer\"]/div/div/span[1]")));
        WebElement option = select.getFirstSelectedOption();
        assertEquals("Контрагент", option.getText());
        return this;
    }

}
