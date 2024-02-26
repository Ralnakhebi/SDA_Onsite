package HW.day04;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;

public class HW_Buttons {

    static WebDriver driver;

    @BeforeClass
    public static void setUp(){

        driver= new ChromeDriver();
        driver.manage().window().maximize();
        //http://the-internet.herokuapp.com/add_remove_elements/
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");

    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }


    @Test
    public void task1(){
        //Click on the "Add Element" button 100 times.
                //Write a function that takes a number, and clicks the "Delete" button.
                //Given number of times, and then validates that given number of buttons was deleted.
        //1. Method: createButtons(100)
        //2. Method: DeleteButtonsAndValidate(40)

        createButton(100);
        int NumberofButtenDeleted = DeleteButtonsAndValidate(40);

        System.out.println("NumberofButtenDeleted = " + NumberofButtenDeleted);

    }

    public void createButton(int numberofButton){
        WebElement button = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        for (int i=0; i<numberofButton;i++) {
                button.click();
        }


    }
    public int DeleteButtonsAndValidate(int numberofButtontoDelete){
        int NumberofButtenDeleted=0;

        List<WebElement> deleteButton =driver.findElements(By.xpath("//button[@class='added-manually']"));
        try {

            for (int i=0;i<numberofButtontoDelete;i++){
                if(deleteButton.get(i).isDisplayed()){
                    deleteButton.get(i).click();
                    NumberofButtenDeleted++;
                }
            }}catch(org.openqa.selenium.StaleElementReferenceException ex) {
            ex.getStackTrace();
        }

        return NumberofButtenDeleted;
    }
}
