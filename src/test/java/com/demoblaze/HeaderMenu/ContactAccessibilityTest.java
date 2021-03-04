package com.demoblaze.HeaderMenu;

import com.demoblaze.base.BaseTest;
import com.demoblaze.pom.ContactPage;
import com.demoblaze.pom.HomePage;
import com.deque.axe.AXE;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.URL;

public class ContactAccessibilityTest extends BaseTest {

    private static final URL scriptUrl = ContactAccessibilityTest.class.getResource("/axe.min.js");

    @BeforeClass
    public void setup() {
        HomePage.clickContact();
        assert (ContactPage.isContactBoxVisible());
    }

    @Test
    public void contactBoxAccessibilityTest(){
        JSONObject responseJson = new AXE.Builder(driver,scriptUrl).analyze();
        JSONArray violations = responseJson.getJSONArray("violations");

        if (violations.length() == 0){
            System.out.println("No Issues");
        }
        else{
            AXE.writeResults("ContactBox", responseJson);
            Assert.assertTrue(false,AXE.report(violations));
        }
    }

    @Test
    public void contactBoxAccessibilityTestWithSelector(){
        JSONObject responseJson = new AXE.Builder(driver,scriptUrl).include("a").analyze();  //"title"
        JSONArray violations = responseJson.getJSONArray("violations");

        if (violations.length() == 0){
            System.out.println("No Issues");
        }
        else{
            AXE.writeResults("ContactBoxAccessibilityWithSelector", responseJson);
            Assert.assertTrue(false,AXE.report(violations));
        }
    }

    @Test
    public void contactBoxAccessibilityTestWithWebElement(){
        JSONObject responseJson = new AXE.Builder(driver,scriptUrl).analyze(driver.findElement(By.id("nava")));  //"title"
        JSONArray violations = responseJson.getJSONArray("violations");

        if (violations.length() == 0){
            System.out.println("No Issues");
        }
        else{
            AXE.writeResults("ContactBoxAccessibilityWithWebElement", responseJson);
            Assert.assertTrue(false,AXE.report(violations));
        }
    }

    @Test
    public void contactBoxAccessibilityTestWithSkipFrames(){
        JSONObject responseJson = new AXE.Builder(driver,scriptUrl).skipFrames().analyze();
        JSONArray violations = responseJson.getJSONArray("violations");

        if (violations.length() == 0){
            System.out.println("No Issues");
        }
        else{
            AXE.writeResults("ContactBoxAccessibilityWithSkipFrames", responseJson);
            Assert.assertTrue(false,AXE.report(violations));
        }
    }

    @Test
    public void contactBoxAccessibilityTestWithIncludeExclude(){
        JSONObject responseJson = new AXE.Builder(driver,scriptUrl).include("title").exclude("a").analyze();
        JSONArray violations = responseJson.getJSONArray("violations");

        if (violations.length() == 0){
            System.out.println("No Issues");
        }
        else{
            AXE.writeResults("ContactBoxAccessibilityWithIncludeExclude", responseJson);
            System.out.println(responseJson);
            Assert.assertTrue(false,AXE.report(violations));
        }
    }
}
