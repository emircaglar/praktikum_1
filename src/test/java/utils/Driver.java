package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class Driver {
    public static WebDriver driver;// Zuerst Singleton Driver habe ich definiert

    // einen erforderlichen driver wurde fur mein neu Projekt definiert
    @BeforeClass
    public static WebDriver getDriver() {

        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();

            driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get("https://demo.openmrs.org/openmrs/login.htm");
        }
        return driver;
    }

   // Am ende des Testes soll ich aufhören
    @AfterClass
    public static void DriverQuit() {


        if (driver != null) {
            driver.quit();
            driver = null;
        }

    }

}
