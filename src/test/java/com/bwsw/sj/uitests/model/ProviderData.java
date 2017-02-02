package com.bwsw.sj.uitests.model;

public class ProviderData {
    private final String name;
    private final String description;
    private final String host;

    public ProviderData(String name, String description, String host) {
        this.name = name;
        this.description = description;
        this.host = host;
    }

    public String getName() {

        return name;
    }

    public String getDescription() {

        return description;
    }

    public String getHost() {

        return host;
    }
}
