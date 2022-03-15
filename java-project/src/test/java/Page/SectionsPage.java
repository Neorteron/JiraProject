package Page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SectionsPage {

    public DesignerPage openNewSection(){
        //$(By.xpath("//button[contains(., 'New section')]")).click();
        open("https://misp-qa.by2.epm-chrt.projects.epam.com/admin/templates/sections/designer");
        return new DesignerPage();
    }


}
