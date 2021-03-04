package com.demoblaze.pom;

import com.demoblaze.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class HomePage extends BaseTest {

    private static WebElement categories =  driver.findElement(By.id("cat"));
    private static WebElement contactLink = driver.findElement(By.cssSelector("a[data-target='#exampleModal']"));
    private static WebElement cartLink = driver.findElement(By.id("cartur"));

    public static boolean onPage(){
        try {
            waitForVisible(categories);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }

    public static void clickContact(){
        waitForVisible(contactLink);
        contactLink.click();
    }

    public static void clickCart(){
        waitForVisible(cartLink);
        cartLink.click();
    }
}
