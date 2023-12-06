package com.aster.podcastManager;

public class Podcast {
    private Integer id;
    private String name;
    private String url;
    private String secretToker;
    
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
    public String getSecretToker() {
        return secretToker;
    }
    public void setSecretToker(String secretToker) {
        this.secretToker = secretToker;
    }
}
