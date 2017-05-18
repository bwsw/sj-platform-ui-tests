package com.bwsw.sj.uitests.tests.providers;

import com.bwsw.sj.uitests.model.ProviderData;
import com.bwsw.sj.uitests.tests.TestBase;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProviderSearchTests  extends TestBase{
    ProviderData providerData = new ProviderData("zookeeper-auto-search" + System.currentTimeMillis(), "Zookeeper-auto description"  + System.currentTimeMillis(), "176.120.25.19:2181", "zookeeper");


    @BeforeMethod
    public void ensurePreconditions() {

        applicationManager.getProviderHelper().createProvider(providerData);
    }

    @Test
    public void testExistingProviderSearch() {
        applicationManager.getBaseHelper().refreshPage();
        applicationManager.getProviderHelper().goToProvidersPage();
        applicationManager.getBaseHelper().waitForElement(By.xpath("//html"));
        applicationManager.getProviderHelper().searchProvider(providerData);
    }

    @Test
    public void testNonexistentProviderSearch() {
        applicationManager.getBaseHelper().refreshPage();
        applicationManager.getProviderHelper().goToProvidersPage();
        applicationManager.getBaseHelper().waitForElement(By.xpath("//html"));
        applicationManager.getProviderHelper().searchNonexistentProvider(providerData);
    }
}
