package day13;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.io.File;

public class C03Log4j_UseProperties extends TestBase {

    public static void main(String[] args) {

        PropertyConfigurator.configure("log4j.properties");

        Logger logger = Logger.getLogger(C03Log4j_UseProperties.class);

        logger.trace("This is a trace message");
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");



    }
    @Test
    public void test() throws InterruptedException {
        //Go to URL: https://healthunify.com/bmicalculator/
        driver.get("https://healthunify.com/bmicalculator/");
        //Entring weight
        PropertyConfigurator.configure("log4j.properties");
        Logger logger = Logger.getLogger(C03Log4j_UseProperties.class);

        logger.trace("This is a trace message");
        //Selecting kilograms
        WebElement we = driver.findElement(By.name("wg"));
        we.sendKeys("50");
        logger.info("Selecting kilograms"+we.getText());

        //Selecting height in feet
        WebElement sw = driver.findElement(By.name("opt2"));
        Select s= new Select(sw);
        s.selectByValue("3");
        logger.info("Selecting height in feet"+s.getFirstSelectedOption().getText());

        //Selecting height in inchs
        WebElement si = driver.findElement(By.name("opt3"));
        Select s2= new Select(sw);
        s2.selectByValue("2");
        logger.info("Selecting height in inchs"+s2.getFirstSelectedOption().getText());

        //Clicking on calculate
        WebElement cal = driver.findElement(By.name("cc"));
        Actions actions = new Actions(driver);
        actions.click(cal)
                        .perform();
        logger.info("Clicking on calculate"+cal.getText());
        //Getting SIUnit value
        Thread.sleep(1000);
        WebElement su = driver.findElement(By.name("si"));
        logger.info("SIUnit is"+su.getText());

        //Getting USUnit value
        WebElement us = driver.findElement(By.name("us"));
        System.out.println("us.getText() = " + us.getText());
        logger.info("USUnit is"+us.getText());
        //Getting UKUnit value
        WebElement uk = driver.findElement(By.name("uk"));
        logger.info("UKUnit is"+uk.getText());
        //Getting overall description
        logger.debug("This is a debug message");

    }
}