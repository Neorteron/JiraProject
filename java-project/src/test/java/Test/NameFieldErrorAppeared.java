package Test;

import Page.DesignerPage;
import Page.LoginPage;
import com.github.hardnorth.common.config.ConfigLoader;
import com.github.hardnorth.common.config.ConfigProvider;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class NameFieldErrorAppeared {

    @BeforeClass
    public void openDesignerPage(){
        ConfigProvider Provider = new ConfigLoader().get();
        LoginPage loginPage = new LoginPage();

        loginPage.openPage()
                .insertCredentials(Provider.getProperty("testdata.loginName.value", String.class), Provider.getProperty("testdata.loginPassword.value", String.class))
                .submit()
                .openNewSection();
    }

    @Test
    public void nameFieldErrorAppearedTest()   {

        DesignerPage designerPage = new DesignerPage();
        designerPage.addBooleanInput()
                .fillNameWithMoreThan100Characters()
                .clickLabelInput();

        Assert.assertTrue(designerPage.nameErrorMassageIsDisplayed(), "Error Massage is not Displayed");
    }

    @Test
    public void nameFieldErrorColorIsRedTest(){
        DesignerPage designerPage = new DesignerPage();
        designerPage.addBooleanInput()
                .fillNameWithMoreThan100Characters()
                .clickLabelInput();

        String errorColor = Color.fromString(designerPage.getErrorTextColor()).asHex();
        Assert.assertTrue(errorColor.contains("#f44336"), "Error color not match #f44336");
    }

    @Test
    public void borderNameColorIsRedTest(){

        DesignerPage designerPage = new DesignerPage();
        designerPage.addBooleanInput()
                .fillNameWithMoreThan100Characters()
                .clickLabelInput();

        String borderNameColor = Color.fromString(designerPage.getNameBorderColor()).asHex();
        Assert.assertTrue(borderNameColor.contains("#f44336"), "Border name color not match #f44336");
    }


}
