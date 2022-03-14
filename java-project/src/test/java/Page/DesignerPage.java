package Page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class DesignerPage {

    public DesignerPage addBooleanInput(){
        $(By.xpath("//button[contains(., 'Add input')]")).click();
        $(By.xpath("//li[contains(., 'Boolean')]")).click();
        return this;
    }

    public DesignerPage fillNameWithMoreThan100Characters(){
        $(By.name("markupInputs[0].name")).setValue("AsterixPanaramixObelixGeroiksAbramixAdoramixPanoramixGedefixNaturamixPlaginotixOmegonixZanaramixLoreomix");
        return this;
    }

    public DesignerPage clickLabelInput(){
        $(By.name("markupInputs[0].label")).click();
        return this;
    }

    public String getErrorTextColor(){
        return $(By.xpath("//p[contains(., 'Please enter at most 100 characters')]")).getCssValue("color");
    }

    public String getNameBorderColor(){
        return $(By.xpath("//fieldset[contains(., 'Name')]")).getCssValue("border-bottom-color");
    }


    public boolean nameErrorMassageIsDisplayed() {
        return $(By.xpath("//p[contains(., 'Please enter at most 100 characters')]")).isDisplayed();
    }
}
