package Test;

import Page.DesignerPage;
import Page.LoginPage;
import com.github.hardnorth.common.config.ConfigLoader;
import com.github.hardnorth.common.config.ConfigProvider;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class NameFieldErrorAppeared {


    @Test
    public void NameFieldErrorAppearedTest()   {


        ConfigProvider Provider = new ConfigLoader().get();
        LoginPage loginPage = new LoginPage();
        DesignerPage designerPage = loginPage.openPage()
                .insertCredentials(Provider.getProperty("testdata.loginName.value", String.class), Provider.getProperty("testdata.loginPassword.value", String.class))
                .submit()
                .clickNewSection()
                .addBooleanInput()
                .fillNameWithMoreThan100Characters()
                .clickLabelInput();

        String errorColor = Color.fromString(designerPage.getErrorTextColor()).asHex();//#f44336
        String borderNameColor = Color.fromString(designerPage.getNameBorderColor()).asHex();//#f44336

        SoftAssert softAssertion= new SoftAssert();
        softAssertion.assertTrue(designerPage.nameErrorMassageIsDisplayed(), "Error Massage is not Displayer");
        softAssertion.assertTrue(errorColor.contains("#f44336"), "Error color not match #f44335");
        softAssertion.assertTrue(borderNameColor.contains("#f44336"), "Border name color not match #f44335");
        softAssertion.assertAll();
    }




}
