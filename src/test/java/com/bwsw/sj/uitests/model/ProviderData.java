package com.bwsw.sj.uitests.model;

public class ProviderData {
    private final String name;
    private final String description;
    private final String host;
    private final String type;

    public ProviderData(String name, String description, String host, String type) {
        this.name = name;
        this.description = description;
        this.host = host;
        this.type = type;
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

    public String getType() {

        return type;
    }
}
