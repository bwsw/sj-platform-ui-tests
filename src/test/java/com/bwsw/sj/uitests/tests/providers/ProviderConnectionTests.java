package com.bwsw.sj.uitests.tests.providers;


import com.bwsw.sj.uitests.model.ProviderData;
import com.bwsw.sj.uitests.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProviderConnectionTests extends TestBase {

    ProviderData providerData = new ProviderData("zookeeper-auto-connection" + System.currentTimeMillis(), "Zookeeper-auto description"  + System.currentTimeMillis(), "176.120.25.19:2181");


    @BeforeMethod
    public void ensurePreconditions() {

        applicationManager.getProviderHelper().createProvider(providerData);
    }

    @Test
    public void testProviderConnection() {
        applicationManager.getBaseHelper().refreshPage();
        applicationManager.getProviderHelper().goToProvidersPage();
        applicationManager.getBaseHelper().waitForElement(By.xpath("//html"));
        applicationManager.getProviderHelper().connectionProvider(providerData);
        applicationManager.getProviderHelper().checkConnectionMessage(providerData);
        }
}
