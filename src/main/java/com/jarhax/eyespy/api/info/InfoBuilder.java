package com.jarhax.eyespy.api.info;

import com.hypixel.hytale.server.core.Message;

public class InfoBuilder {

    private String icon;
    private Message header;
    private Message body;
    private Message footer;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Message getHeader() {
        return header;
    }

    public void setHeader(Message header) {
        this.header = header;
    }

    public Message getBody() {
        return body;
    }

    public void setBody(Message body) {
        this.body = body;
    }

    public Message getFooter() {
        return footer;
    }

    public void setFooter(Message footer) {
        this.footer = footer;
    }
}