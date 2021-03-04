package com.demoblaze.HeaderMenu;

import com.demoblaze.base.BaseTest;
import com.demoblaze.pom.CartPage;
import com.demoblaze.pom.HomePage;
import com.deque.axe.AXE;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

public class CartAccessibilityTest extends BaseTest {

    private static final URL scriptUrl = CartAccessibilityTest.class.getResource("/axe.min.js");

    @BeforeClass
    public void setup() {
        HomePage.clickCart();
        assert (CartPage.isPlaceOrderVisible());
    }

    @Test
    public void cartAccessibilityTest(){
        JSONObject responseJson = new AXE.Builder(driver,scriptUrl).analyze();
        JSONArray violations = responseJson.getJSONArray("violations");

        if (violations.length() == 0){
            System.out.println("No Issues");
        }
        else{
            AXE.writeResults("CartAccessibility", responseJson);
            Assert.assertTrue(false,AXE.report(violations));
        }
    }

    @Test
    public void cartAccessibilityTestWithSelector(){
        JSONObject responseJson = new AXE.Builder(driver,scriptUrl).include("a").analyze();  //"title"
        JSONArray violations = responseJson.getJSONArray("violations");

        if (violations.length() == 0){
            System.out.println("No Issues");
        }
        else{
            AXE.writeResults("CartAccessibilityWithSelector", responseJson);
            Assert.assertTrue(false,AXE.report(violations));
        }
    }

    @Test
    public void cartAccessibilityTestWithWebElement(){
        JSONObject responseJson = new AXE.Builder(driver,scriptUrl).analyze(driver.findElement(By.id("nava")));  //"title"
        JSONArray violations = responseJson.getJSONArray("violations");

        if (violations.length() == 0){
            System.out.println("No Issues");
        }
        else{
            AXE.writeResults("CartAccessibilityWithWebElement", responseJson);
            Assert.assertTrue(false,AXE.report(violations));
        }
    }

    @Test
    public void cartAccessibilityTestWithSkipFrames(){
        JSONObject responseJson = new AXE.Builder(driver,scriptUrl).skipFrames().analyze();
        JSONArray violations = responseJson.getJSONArray("violations");

        if (violations.length() == 0){
            System.out.println("No Issues");
        }
        else{
            AXE.writeResults("CartAccessibilityWithSkipFrames", responseJson);
            Assert.assertTrue(false,AXE.report(violations));
        }
    }

    @Test
    public void cartAccessibilityTestWithIncludeExclude(){
        JSONObject responseJson = new AXE.Builder(driver,scriptUrl).include("title").exclude("a").analyze();
        JSONArray violations = responseJson.getJSONArray("violations");

        if (violations.length() == 0){
            System.out.println("No Issues");
        }
        else{
            AXE.writeResults("CartAccessibilityWithIncludeExclude", responseJson);
            System.out.println(responseJson);
            Assert.assertTrue(false,AXE.report(violations));
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
