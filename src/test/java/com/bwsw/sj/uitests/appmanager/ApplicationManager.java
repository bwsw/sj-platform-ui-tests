package com.bwsw.sj.uitests.appmanager;

import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private BaseHelper baseHelper;
    private ProviderHelper providerHelper;
    FirefoxDriver wd;

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://stream-juggler.z1.netpoint-dc.com:18080");
        providerHelper = new ProviderHelper(wd);
        baseHelper = new BaseHelper(wd);
    }

    public void stop() {

        wd.quit();
    }

    public ProviderHelper getProviderHelper() {

        return providerHelper;
    }

    public BaseHelper getBaseHelper() {

        return baseHelper;
    }
}
