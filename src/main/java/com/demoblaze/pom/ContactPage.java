package com.demoblaze.pom;

import com.demoblaze.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactPage extends BaseTest {

    private static WebElement contactModalTitle = driver.findElement(By.cssSelector("div.modal-content h5#exampleModalLabel"));

    public static boolean isContactBoxVisible(){
        try{
            waitForVisible(contactModalTitle);
            return true;
        }
        catch (Exception ex){
            return false;
        }
    }
}
