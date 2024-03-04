package HW.day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Task1 extends TestBase {
    @Test
    public void test(){

        By bank = By.id("credit2");
        By fiveth = By.xpath("//li[@id='fourth'][2]");
        By fiveth2 = By.xpath("//li[@id='fourth'][1]");

        By sales = By.id("credit1");
        By Account = By.id("loan");

        By debitSide = By.xpath("//ol[contains(@class,'field14')]");
        By creditSideAmount = By.xpath("//ol[contains(@id,'amt8')]");
        By debitSideAmount = By.xpath("//ol[contains(@id,'amt7')]");

        By perfect = By.xpath("//a[contains(@class,'button-green')][1]");
        //Go to URL: http://demo.guru99.com/test/drag_drop.html
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        WebElement bankButton = driver.findElement(bank);

        WebElement fivethButton = driver.findElement(fiveth);
        WebElement fivethButton2 = driver.findElement(fiveth2);

        WebElement fivethField = driver.findElement(creditSideAmount);
        WebElement fivethField2 = driver.findElement(debitSideAmount);

        WebElement fieldInDebitSide = driver.findElement(debitSide);

        WebElement salesBox =driver.findElement(sales);
        WebElement creditSideBox =driver.findElement(Account);
        WebElement perfectMessage = driver.findElement(perfect);

        //Drag and drop the BANK button to the Account section in DEBIT SIDE
        actions
                .dragAndDrop(bankButton,fieldInDebitSide)
                .perform();

        //Drag and drop the SALES button to the Account section in CREDIT SIDE
        actions
                .dragAndDrop(salesBox,creditSideBox)
                .perform();

        //Drag and drop the 5000 button to the Amount section in DEBIT SIDE
        actions
                .dragAndDrop(fivethButton,fivethField)
                .perform();
        //Drag and drop the second 5000 button to the Amount section in CREDIT SIDE
        actions
                .dragAndDrop(fivethButton2,fivethField2)
                .perform();
        //Verify the visibility of Perfect text.
        Assert.assertTrue(perfectMessage.isDisplayed());

    }
}
