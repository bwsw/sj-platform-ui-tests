package com.bwsw.sj.uitests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class BaseHelper {

    protected WebDriver wd;

    public BaseHelper(WebDriver wd) {

        this.wd = wd; 
    }

    public void refreshPage() {

        wd.get("http://stream-juggler.z1.netpoint-dc.com:28080");
    }

    public void click(By locator) {

        wd.findElement(locator).click();
    }

    public void type(By locator, String text) {

        click(locator);
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void select (By locator, String value) {

        Select select = new Select(wd.findElement(locator));
        select.selectByValue(value);
    }

    public void waitForElement(By path) {
        WebDriverWait wait = new WebDriverWait (wd, 10);
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(path));
    }

    public void checkTextIsPresent(String text, By locator) {
        assertTrue(wd.findElement(locator).getText().contains(text));
    }

    public void checkTextIsNotPresent(String text, By locator) {
        assertFalse(wd.findElement(locator).getText().contains(text));
    }

    public void checkMessage(String text, By locator) {

        assertTrue(wd.findElement(locator).getText().contains(text));
    }

    public void checkElementsCount (Integer count, By locator) {
        Integer listsize = wd.findElements(locator).size();
        assertEquals (count, listsize);
    }

   // public void checkElementIsNotPresent (By locator) {
    //    assertTrue(wd.findElements(locator).isEmpty());
   // }

    public void sleep() {
        wd.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
}
