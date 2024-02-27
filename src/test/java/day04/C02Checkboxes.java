package day04;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class C02Checkboxes {


    /*
    * Go to https://the-internet.herokuapp.com/checkboxes
Locate the elements of checkboxes.
Then click on checkbox 1 if box is not selected.
Then click on checkbox 2 if box is not selected.
Then verify that checkbox 1 is checked.*/

    static WebDriver driver;

    @Test
    public void test() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*"); // --> prevent error
        options.addArguments("incognito");
        driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkBoxes=driver.findElements(By.xpath("//*[@type='checkbox']"));

        //checkBoxes.get(0).click();
//        if(!(checkBoxes.get(0).isSelected())) {
//            checkBoxes.get(0).click();
//            System.out.println("check box 2 is selected ..");
//        }else {
//            System.out.println("check box 2 is already selected ..");
//
//        }
        String isSelceted =checkBoxes.get(0).isSelected()? "check box 2 is selected ..":"check box 2 is not selected ..";
        System.out.println("isSelceted = " + isSelceted);

        if(!(checkBoxes.get(1).isSelected())) {
            checkBoxes.get(1).click();
            System.out.println("check box 2 is selected ..");
        }else {
            System.out.println("check box 2 is already selected ..");

        }
        //Assert.assertTrue((checkBoxes.get(0).isSelected()));
        Assert.assertTrue((checkBoxes.get(1).isSelected()));


    }

    @AfterClass
    public static void tearDown(){
        driver.close();
        driver.quit();
    }
}
