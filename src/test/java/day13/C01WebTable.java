package day13;

import com.google.common.collect.Table;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C01WebTable extends TestBase {

    @Test
    public void test(){

        //Go to URL: http://demo.guru99.com/test/web-table-element.php
        //To find third row of table
        //To get 3rd row's 2nd column data
        //Get all the values of a Dynamic Table
        driver.get("http://demo.guru99.com/test/web-table-element.php");
        WebElement Table= driver.findElement(By.xpath("//table[@class='dataTable']/tbody"));
        WebElement row3= Table.findElement(By.xpath(".//tr[3]"));
        WebElement cell32 = row3.findElement(By.xpath(".//td[2]"));
        System.out.println("row3.getText() = " + row3.getText());
        System.out.println("cell32 = " + cell32.getText());
        List<WebElement> rows= driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr"));
        WebElement row = driver.findElement(By.xpath("//table[@class='dataTable']/tbody/tr"));
        List<WebElement> cells1 = new ArrayList<>();
        List<WebElement> cell =new ArrayList<>();
//        for (WebElement w : rows){
//            cell = w.findElements(By.xpath(".//td"));
//            for (WebElement c : cell){
//                cells1.add(c);
//            }
//        }
//        for (WebElement webElement : cells1){
//            System.out.println("webElement.getText() = " + webElement.getText());
//        }

        List<WebElement> cells= new ArrayList<>();
        for (int i=1 ; i<= rows.size();i++){
            cells= row.findElements(By.xpath(".//td"));
            for (int j=1 ; j<=cells.size(); j++){
                System.out.println("Cell : \nRow: "+i+" Column: "+j+": "+driver.findElement(
                        By.xpath("//table[@class='dataTable']" +
                        "/tbody/tr["+i+"]/td["+j+"]")).getText());
            }
        }

    }
}
