package com.bwsw.sj.uitests.tests.providers.zookeeper;

import com.bwsw.sj.uitests.model.ProviderData;
import com.bwsw.sj.uitests.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ZookeeperProviderCreationTests extends TestBase {

    ProviderData providerData = new ProviderData("zookeeper-auto-creation" + System.currentTimeMillis(), "Zookeeper-auto description"  + System.currentTimeMillis(), "176.120.25.19:2181", "zookeeper");

    @Test
    public void testProviderCreation() {
        applicationManager.getProviderHelper().goToProvidersPage();
        applicationManager.getBaseHelper().waitForElement(By.xpath("//main[@class='main']//button[.='Create Provider             ']"));
        applicationManager.getProviderHelper().initProviderCreation();
        applicationManager.getBaseHelper().waitForElement(By.name("providerName"));
        applicationManager.getProviderHelper().fillProviderForm(providerData);
        applicationManager.getProviderHelper().submitProviderCreation();
        applicationManager.getBaseHelper().waitForElement(By.xpath("//html"));
        applicationManager.getProviderHelper().checkCreationMessage(providerData);
        applicationManager.getProviderHelper().goToProvidersPage();
        applicationManager.getProviderHelper().checkProviderInList(providerData);
        applicationManager.getProviderHelper().selectProviderFromList(providerData);
        applicationManager.getProviderHelper().checkProviderDetails(providerData);
    }
}
