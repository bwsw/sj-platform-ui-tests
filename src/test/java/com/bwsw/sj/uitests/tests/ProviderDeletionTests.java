package com.bwsw.sj.uitests.tests;

import com.bwsw.sj.uitests.model.ProviderData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProviderDeletionTests extends TestBase {

    ProviderData providerData = new ProviderData("zookeeper-auto" + System.currentTimeMillis(), "Zookeeper-auto description"  + System.currentTimeMillis(), "176.120.25.19:2181");

    @BeforeMethod
    public void ensurePreconditions() {
        applicationManager.getProviderHelper().createProvider(providerData);
    }

    @Test
    public void testProviderDeletion() {
        applicationManager.getBaseHelper().refreshPage();
        applicationManager.getProviderHelper().goToProvidersPage();
        applicationManager.getProviderHelper().checkProviderInList(providerData);
        applicationManager.getProviderHelper().deleteProvider(providerData);
        applicationManager.getBaseHelper().refreshPage();
        applicationManager.getProviderHelper().goToProvidersPage();
        applicationManager.getProviderHelper().checkProviderIsNotInList(providerData);
    }
}