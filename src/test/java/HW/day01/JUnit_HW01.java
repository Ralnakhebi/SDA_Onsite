package HW.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class JUnit_HW01 {

    public static void main(String[] args) {
        WebDriver driver=new EdgeDriver();
        driver.get("https://www.youtube.com");
        String pageTitle= driver.getTitle();
        System.out.println("pageTitle of youtube : " + pageTitle);
        if(pageTitle.contains("video")){
            System.out.println("does contains a video word. ");
    }else {
        System.out.println("doesn't contains a video word. ");}
        driver.quit();
    }


}
