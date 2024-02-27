package HW.day05;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Challenge {


    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("disable-popup-blocking");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        //driver.quit();
    }


    @Test
    public void test() throws InterruptedException {
        driver.get("https://webdriveruniversity.com/To-Do-List/index.html");
        WebElement toDoField = driver.findElement(By.xpath("//input[@type='text']"));

        List<String> TodoList=new ArrayList<>(2);
        TodoList.add("Doing Locators Homework");
        TodoList.add("Solve Challenges");

        for (String taskTodo : TodoList){
            toDoField.sendKeys(taskTodo, Keys.ENTER);

            List<WebElement> lastOne=driver.findElements(By.xpath("//i[contains(@class,'fa-trash')]"));
            int last=lastOne.size();

            //WebElement makeDeleteButtonVisible = driver.findElement(RelativeLocator.with(By.tagName("li")).below(lastOne.get(2)));
            //with RelativeLocator
            lastOne.get(last-1).click();

            if(lastOne.get(last-1).isDisplayed()){
                lastOne.get(last-1).click();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            boolean result= lastOne.get(last-1).getAttribute("class").equals("completed");

            System.out.println(result);
            //Assert.assertNull("The task wasn't deleted Successfully ..",result);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        }



    }
}
