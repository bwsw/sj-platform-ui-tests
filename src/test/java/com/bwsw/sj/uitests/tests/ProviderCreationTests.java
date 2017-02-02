package com.bwsw.sj.uitests.tests;

import com.bwsw.sj.uitests.model.ProviderData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class ProviderCreationTests  extends TestBase {

    @Test
    public void testProviderCreation() {
        applicationManager.getProviderHelper().goToProvidersPage();
        applicationManager.getProviderHelper().initProviderCreation();
        applicationManager.getBaseHelper().waitForElement(By.name("providerName"));
        applicationManager.getProviderHelper().fillProviderForm(new ProviderData("zookeeper-auto" + System.currentTimeMillis(), "Zookeeper-auto description", "176.120.25.19:2181"));
        applicationManager.getProviderHelper().submitProviderCreation();
    }
}
