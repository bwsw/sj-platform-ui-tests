package com.bwsw.sj.uitests.appmanager;


import com.bwsw.sj.uitests.model.ProviderData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ProviderHelper extends BaseHelper{

    public ProviderHelper (FirefoxDriver wd) {
        super(wd);

    }

    public void submitProviderCreation() {
        click(By.xpath("//main[@class='main']//button[.='Create         ']"));
    }

    public void fillProviderForm(ProviderData providerData) {
        if (!wd.findElement(By.xpath("//main[@class='main']/div/sj-providers/div[2]/div/div/div[2]/form/fieldset[1]/div/select//option[@value='zookeeper']")).isSelected()) {
            wd.findElement(By.xpath("//main[@class='main']/div/sj-providers/div[2]/div/div/div[2]/form/fieldset[1]/div/select//option[@value='zookeeper']")).click();
        }
        type(By.name("providerName"),providerData.getName());
        type(By.name("providerDescription"),providerData.getDescription());
        type(By.xpath("//main[@class='main']/div/sj-providers/div[2]/div/div/div[2]/form/fieldset[4]/div/div/input"),providerData.getHost());
    }

    public void initProviderCreation() {
        click(By.xpath("//main[@class='main']//button[.='Create Provider             ']"));
    }

    public void goToProvidersPage() {
       click(By.linkText("Providers"));
    }
}
