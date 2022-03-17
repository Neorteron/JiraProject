package Test;

import Page.DesignerPage;
import Page.LoginPage;
import Util.Listener;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import com.github.hardnorth.common.config.ConfigLoader;
import com.github.hardnorth.common.config.ConfigProvider;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



@Listeners({ReportPortalTestNGListener.class, Listener.class})
public class NameFieldErrorAppeared {
    private DesignerPage designerPage = new DesignerPage();
    private ConfigProvider Provider = new ConfigLoader().get();
    private LoginPage loginPage = new LoginPage();

    @BeforeClass
    public void openDesignerPage(){
        loginPage.openPage()
                .insertCredentials(Provider.getProperty("testdata.loginName.value", String.class), Provider.getProperty("testdata.loginPassword.value", String.class))
                .submit()
                .openNewSection()
                .addBooleanInput()
                .fillNameWithMoreThan100Characters()
                .clickLabelInput();
    }

    @Test
    public void nameFieldErrorAppearedTest()   {
        Assert.assertTrue(designerPage.nameErrorMassageIsDisplayed(), "Error Massage is not Displayed");
    }

    @Test
    public void nameFieldErrorColorIsRedTest(){
        String errorColor = Color.fromString(designerPage.getErrorTextColor()).asHex();
        Assert.assertTrue(errorColor.contains("#f44336"), "Error color not match #f44336");
    }

    @Test
    public void borderNameColorIsRedTest(){
        String borderNameColor = Color.fromString(designerPage.getNameBorderColor()).asHex();
        Assert.assertTrue(borderNameColor.contains("#f44336"), "Border name color not match #f44336");
    }


}
