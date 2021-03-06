package com.bwsw.sj.uitests.appmanager;

import com.bwsw.sj.uitests.model.ProviderData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ProviderHelper extends BaseHelper{

    public ProviderHelper (FirefoxDriver wd) {
        super(wd);

    }

    public void goToProvidersPage() {

        click(By.linkText("Providers"));
    }

    public void initProviderCreation() {
        click(By.xpath("//main[@class='main']//button[.='Create Provider             ']"));
    }

    public void fillProviderForm(ProviderData providerData) {
        select(By.xpath("//main[@class='main']/div/sj-providers/div[2]/div/div/div[2]/form/fieldset[1]/div/select")
                ,providerData.getType());
        type(By.name("providerName"),providerData.getName());
        type(By.name("providerDescription"),providerData.getDescription());
        type(By.xpath("//main[@class='main']/div/sj-providers/div[2]/div/div/div[2]/form/fieldset[4]/div/div/input"),providerData.getHost());
    }

    public void submitProviderCreation() {

        click(By.xpath("//main[@class='main']//button[.='Create         ']"));
    }

    public void createProvider(ProviderData providerData) {
        goToProvidersPage();
        waitForElement(By.xpath("//main[@class='main']//button[.='Create Provider             ']"));
        initProviderCreation();
        waitForElement(By.name("providerName"));
        fillProviderForm(providerData);
        submitProviderCreation();
    }

    public void deleteProvider(ProviderData providerData) {
        click(By.xpath("//tr/td[contains(text(),'"+providerData.getName()+"')]/../td[@class='actions-column']/button[@title='Delete provider']"));
        waitForElement(By.cssSelector("button.btn.btn-danger"));
        click(By.cssSelector("button.btn.btn-danger"));
    }

    public void connectionProvider(ProviderData providerData) {
        click(By.xpath("//tr/td[contains(text(),'"+providerData.getName()+"')]/../td[@class='actions-column']/button[@title='Test connection']"));
    }

    public void checkProviderInList(ProviderData providerData) {
        checkTextIsPresent(providerData.getName(), By.xpath("//div[@class='table-wrapper']"));
        checkTextIsPresent(providerData.getDescription(),  By.xpath("//div[@class='table-wrapper']"));
    }

    public void checkProviderIsNotInList(ProviderData providerData) {
        checkTextIsNotPresent(providerData.getName(),  By.xpath("//div[@class='table-wrapper']"));
        checkTextIsNotPresent(providerData.getDescription(),  By.xpath("//div[@class='table-wrapper']"));
    }

    public void checkCreationMessage(ProviderData providerData) {
        checkMessage("Provider '"+providerData.getName()+"' has been created.",  By.xpath("//sj-alerts"));
    }

    public void checkDeletionMessage(ProviderData providerData) {
        checkMessage("Provider '"+providerData.getName()+"' has been deleted.", By.xpath("//sj-alerts"));
    }

    public void checkConnectionMessage(ProviderData providerData) {
        checkMessage("ProviderModel '"+providerData.getName()+"' is available", By.xpath("//sj-alerts"));
    }

    public void checkProviderDetails(ProviderData providerData) {
        waitForElement(By.xpath("//div[@class='overflow-x-scroll']/ul/li[contains(text(),'"+providerData.getName()+"')]"));
        checkTextIsPresent("Name: "+providerData.getName(), By.xpath("//div[@class='overflow-x-scroll']"));
        checkTextIsPresent("Type: "+providerData.getType(), By.xpath("//div[@class='overflow-x-scroll']"));
        checkTextIsPresent("Description: "+providerData.getDescription(), By.xpath("//div[@class='overflow-x-scroll']"));
        checkTextIsPresent(providerData.getHost(), By.xpath("//div[@class='overflow-x-scroll']"));
    }

    public void selectProviderFromList(ProviderData providerData) {
        click(By.xpath("//tr/td[contains(text(),'"+providerData.getName()+"')]"));
    }

    public void searchProvider(ProviderData providerData) {
        type(By.xpath("//input[@placeholder='Search']"), providerData.getName());
        checkTextIsPresent(providerData.getName(), By.xpath("//div[@class='table-wrapper']"));
        checkElementsCount(1, By.xpath("//div[@class='table-wrapper']/table/tbody/tr"));
    }

    public void searchNonexistentProvider(ProviderData providerData) {
        type(By.xpath("//input[@placeholder='Search']"),"non exist" + System.currentTimeMillis());
        checkTextIsNotPresent(providerData.getName(), By.xpath("//div[@class='table-wrapper']"));
        //checkElementIsNotPresent( By.xpath("//div[@class='table-wrapper']/table/tbody/tr"));
    }
}
