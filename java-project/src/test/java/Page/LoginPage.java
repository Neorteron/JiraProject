package Page;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    public LoginPage openPage(){
        open("https://misp-qa.by2.epm-chrt.projects.epam.com/login");
        return this;
    }

    public LoginPage insertCredentials(String name, String password){
        $(By.name("login")).setValue(name);
        $(By.name("password")).setValue(password);
        return this;
    }
    public SectionsPage submit(){
        $(By.xpath("//button[@type='submit']")).click();
        return new SectionsPage();
    }




}
