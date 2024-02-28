package day06;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02DropDown {

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
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://demoqa.com/select-menu");
        // Dropdown: a drop-down menu
        // Since dropdowns require special interactions, Selenium has created a separate class for dropdowns.
        // Class -> Select

        // When working with dropdowns:
        //  * Locate the <select> element: //select[@id='oldSelectMenu']
        WebElement DropDown1 =driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));

        //  * Create a Select object using the select element:
        Select select = new Select(DropDown1);
        //  * Select select = new Select(webElement)
        //  * Use methods through the select object:
        //       1- selectByIndex(): index of the option element
        select.selectByIndex(0);
        //       2- selectByValue(): value attribute of the option element
        select.selectByValue("red");
        //       3- selectByVisibleText(): visible text of the option element
        select.selectByVisibleText("Purple");

        // Methods used for informational purposes in Select elements:
            //  select.getAllSelectedOptions(); -> Returns all selected values in a multi-select dropdown.
        List<WebElement> allSelected = select.getAllSelectedOptions();
        System.out.println("allSelected.get(0).getText() = " + allSelected.get(0).getText());

            //  select.getFirstSelectedOption(); -> Returns the first selected option.
        WebElement firstSelectedElement = select.getFirstSelectedOption();

            //  select.getOptions(); -> Returns all options of the select element in a list.
        List<WebElement> all = select.getAllSelectedOptions();
        System.out.println("allSelected.get(0).getText() = " + all.get(0).getText());

            //  select.isMultiple(); -> Returns a boolean indicating whether the select element allows multiple selections.
        boolean isMultiSelector = select.isMultiple();
        System.out.println("isMultiSelector = " + isMultiSelector);


        // Deselection methods:
            //  1- deselectByIndex() -> Deselects an option by its index.
        //select.deselectByIndex(0);
            //  2- deselectByValue() -> Deselects an option by its value attribute.
        //select.deselectByValue("1");
            //  3- deselectByVisibleText() -> Deselects an option by its visible text (content).
        //select.deselectByVisibleText("Purple");
            //  4- deselectAll() -> Deselects all options.
        //select.deselectAll();

    }

}
