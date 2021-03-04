package com.demoblaze.pom;

import com.demoblaze.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CartPage extends BaseTest {

    private static WebElement placeOrderButton = driver.findElement(By.cssSelector("button[data-target='#orderModal']"));

    public static boolean isPlaceOrderVisible(){
        try{
            waitForVisible(placeOrderButton);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }
}
