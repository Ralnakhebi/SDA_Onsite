package day14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class C02TesNG {


    //Create tests that depend on each other
    //Create beforeClass and set up settings.
    //By creating interdependent tests;
    //First go to Facebook.
    //Then go to Google depending on Facebook,
    //Then go to Amazon depending on Google
    //Close the driver.
    static WebDriver driver= new ChromeDriver();;

    @Test()

    public void facebookTest(){
        driver.get("https://www.facebook.com");


    }

    @Test(dependsOnMethods = {"facebookTest"})
    public void googleTest(){
        driver.get("https://www.google.com");

    }
    @Test(dependsOnMethods = {"googleTest"})
    public void amazonTest(){
        driver.get("https://www.amazon.com");

    }

}
