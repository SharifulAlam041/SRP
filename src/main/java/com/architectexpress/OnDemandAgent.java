package com.architectexpress;

public class OnDemandAgent {
    private String host;
    private String ip;
    private String imageId;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    @Override
    public String toString() {
        return "OnDemandAgent{" +
                "host='" + host + '\'' +
                ", ip='" + ip + '\'' +
                ", imageId='" + imageId + '\'' +
                '}';
    }
}

