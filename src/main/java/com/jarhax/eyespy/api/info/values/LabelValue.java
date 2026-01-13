package com.jarhax.eyespy.api.info.values;

import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.ui.builder.UICommandBuilder;
import com.jarhax.eyespy.api.info.AnchorBuilder;
import com.jarhax.eyespy.api.info.InfoValue;

import javax.annotation.Nonnull;

public class LabelValue implements InfoValue {

    private final String id;
    private final Message value;
    private int fontSize;
    private int height;

    public LabelValue(String id, Message value) {
        this(id, value, 18);
    }

    public LabelValue(String id, Message value, int fontSize) {
        this.id = id;
        this.value = value;
        this.fontSize = fontSize;
        this.height = this.fontSize * 2;
    }

    public LabelValue fontSize(int fontSize) {
        this.fontSize = fontSize;
        return this;
    }

    public LabelValue setHeight(int height) {
        this.height = height;
        return this;
    }

    @Override
    public void build(@Nonnull UICommandBuilder ui, @Nonnull AnchorBuilder anchorBuilder, String selector) {
        ui.appendInline(selector, """
                Label #%s {
                  Style: LabelStyle(FontSize: %s);
                }""".formatted(this.id, this.fontSize));
        ui.set(selector + " #%s.TextSpans".formatted(this.id), value);
        anchorBuilder.addHeight(this.height);
    }
}
