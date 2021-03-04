package com.demoblaze.Home;

import com.demoblaze.base.BaseTest;
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

public class HomeAccessibilityTest extends BaseTest {

    private static final URL scriptUrl = HomeAccessibilityTest.class.getResource("/axe.min.js");

    @BeforeClass
    public void setup() {
       assert (HomePage.onPage());
    }

    @Test
    public void homeAccessibilityTest(){
        JSONObject responseJson = new AXE.Builder(driver,scriptUrl).analyze();
        JSONArray violations = responseJson.getJSONArray("violations");

        if (violations.length() == 0){
            System.out.println("No Issues");
        }
        else{
            AXE.writeResults("HomeAccessibility", responseJson);
            Assert.assertTrue(false,AXE.report(violations));
        }
    }

    @Test
    public void homeAccessibilityTestWithSelector(){
        JSONObject responseJson = new AXE.Builder(driver,scriptUrl).include("a").analyze();  //"title"
        JSONArray violations = responseJson.getJSONArray("violations");

        if (violations.length() == 0){
            System.out.println("No Issues");
        }
        else{
            AXE.writeResults("HomeAccessibilityWithSelector", responseJson);
            Assert.assertTrue(false,AXE.report(violations));
        }
    }

    @Test
    public void homeAccessibilityTestWithWebElement(){
        JSONObject responseJson = new AXE.Builder(driver,scriptUrl).analyze(driver.findElement(By.id("nava")));  //"title"
        JSONArray violations = responseJson.getJSONArray("violations");

        if (violations.length() == 0){
            System.out.println("No Issues");
        }
        else{
            AXE.writeResults("HomeAccessibilityWithWebElement", responseJson);
            Assert.assertTrue(false,AXE.report(violations));
        }
    }

    @Test
    public void homeAccessibilityTestWithSkipFrames(){
        JSONObject responseJson = new AXE.Builder(driver,scriptUrl).skipFrames().analyze();
        JSONArray violations = responseJson.getJSONArray("violations");

        if (violations.length() == 0){
            System.out.println("No Issues");
        }
        else{
            AXE.writeResults("HomeAccessibilityWithSkipFrames", responseJson);
            Assert.assertTrue(false,AXE.report(violations));
        }
    }

    @Test
    public void homeAccessibilityTestWithIncludeExclude(){
        JSONObject responseJson = new AXE.Builder(driver,scriptUrl).include("title").exclude("a").analyze();
        JSONArray violations = responseJson.getJSONArray("violations");

        if (violations.length() == 0){
            System.out.println("No Issues");
        }
        else{
            AXE.writeResults("HomeAccessibilityWithIncludeExclude", responseJson);
            System.out.println(responseJson);
            Assert.assertTrue(false,AXE.report(violations));
        }
    }
}
