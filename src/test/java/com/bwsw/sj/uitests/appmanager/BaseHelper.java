package com.bwsw.sj.uitests.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;
import static org.junit.Assert.*;

public class BaseHelper {

    protected WebDriver wd;

    public BaseHelper(WebDriver wd) {

        this.wd = wd; 
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

    public void checkText(String text) {
        assertTrue(wd.findElement(By.xpath("//html")).getText().contains(text));
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
