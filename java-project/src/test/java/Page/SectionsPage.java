package Page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SectionsPage {

    public DesignerPage clickNewSection(){
        $(By.xpath("//button[contains(., 'New section')]")).click();
        return new DesignerPage();
    }


}
