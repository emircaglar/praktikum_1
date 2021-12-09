package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Driver;

public class Login extends Driver {

    @Test(priority = 4)
    public void login(){

        WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
        username.clear();
        username.sendKeys("Admin");

        WebElement userpassword=driver.findElement(By.xpath("//input[@id='password']"));
        userpassword.clear();
        userpassword.sendKeys("Admin123");

        WebElement inpatient_Ward=driver.findElement(By.xpath("//li[@id='Inpatient Ward']"));
        inpatient_Ward.click();


        WebElement login_button=driver.findElement(By.id("loginButton"));
        login_button.click();


        WebElement login_text=driver.findElement(By.cssSelector("div[class='col-12 col-sm-12 col-md-12 col-lg-12']"));

        Assert.assertTrue(login_text.getText().contains("Logged"));


        WebElement logout_button=driver.findElement(By.cssSelector("li[class='nav-item logout']>a"));

        logout_button.click();
        inpatient_Ward=driver.findElement(By.xpath("//li[@id='Inpatient Ward']"));
        Assert.assertTrue(inpatient_Ward.getText().contains("Inpatient"));


    }

    @Test(priority = 1)
    public void login_lokation(){

        WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
        username.clear();
        username.sendKeys("Admin");

        WebElement userpassword=driver.findElement(By.xpath("//input[@id='password']"));
        userpassword.clear();
        userpassword.sendKeys("Admin123");

        WebElement login_button=driver.findElement(By.id("loginButton"));
        login_button.click();

      

        WebElement login_falsch_txt=driver.findElement(By.id("sessionLocationError"));

        Assert.assertTrue(login_falsch_txt.getText().contains("choose a location"));


    }
    @Test(priority = 3)
    public void login_falsch_admin(){

        WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
        username.clear();
        username.sendKeys("Arda");

        WebElement userpassword=driver.findElement(By.xpath("//input[@id='password']"));
        userpassword.clear();
        userpassword.sendKeys("Admin123");


        WebElement inpatient_Ward=driver.findElement(By.xpath("//li[@id='Inpatient Ward']"));
        inpatient_Ward.click();



        WebElement login_button=driver.findElement(By.id("loginButton"));
        login_button.click();



        WebElement login_falsch_txt=driver.findElement(By.id("error-message"));

        Assert.assertTrue(login_falsch_txt.getText().contains("Invalid username/password"));


    }

    @Test(priority = 2)
    public void login_falsch_password(){

        WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
        username.clear();
        username.sendKeys("Admin");

        WebElement userpassword=driver.findElement(By.xpath("//input[@id='password']"));
        userpassword.clear();
        userpassword.sendKeys("Admin12356");


        WebElement inpatient_Ward=driver.findElement(By.xpath("//li[@id='Inpatient Ward']"));
        inpatient_Ward.click();



        WebElement login_button=driver.findElement(By.id("loginButton"));
        login_button.click();



        WebElement login_falsch_txt=driver.findElement(By.id("error-message"));

        Assert.assertTrue(login_falsch_txt.getText().contains("Invalid username/password"));

    }

}
