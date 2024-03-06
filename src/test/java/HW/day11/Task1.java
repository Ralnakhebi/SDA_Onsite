package HW.day11;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class Task1 extends TestBase {
    @Test
    public void test(){
        driver.get("https://facebook.com");
        Set<Cookie> cookieSet=driver.manage().getCookies();
        cookieSet.forEach(c -> System.out.println(c));
        Cookie newCookie = new Cookie("TheNewCookie","The content of the new Cookie");
        driver.manage().addCookie(newCookie);
        Assert.assertTrue(driver.manage().getCookieNamed("TheNewCookie").
                getValue().contains("The content of the new Cookie"));
        Assert.assertNotNull(driver.manage().getCookieNamed("TheNewCookie"));

        driver.manage().deleteCookieNamed("TheNewCookie");

        boolean isCookieExist = false;
        Set<Cookie> cookieSet1=driver.manage().getCookies();

        for (Cookie c : cookieSet1){
            if(c.getName().contains("TheNewCookie")){
                isCookieExist=true;
            }
        }
        Assert.assertFalse(isCookieExist);

        driver.manage().deleteAllCookies();
        int size = 0;

        Set<Cookie> cookieSet2=driver.manage().getCookies();

        for (Cookie c : cookieSet2){
            size++;
        }
        Assert.assertTrue(size>0);

    }
}
