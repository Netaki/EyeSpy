package com.jarhax.eyespy.api.info.values;

import com.hypixel.hytale.server.core.ui.builder.UICommandBuilder;
import com.jarhax.eyespy.api.info.AnchorBuilder;
import com.jarhax.eyespy.api.info.InfoValue;

import javax.annotation.Nonnull;

public class IconValue implements InfoValue {

    private final String iconId;

    public IconValue(String iconId) {
        this.iconId = iconId;
    }

    @Override
    public void build(@Nonnull UICommandBuilder ui, @Nonnull AnchorBuilder anchorBuilder, String selector) {
        ui.insertBeforeInline(selector, """
                ItemIcon #Icon {
                    Anchor: (Width: 64, Height: 64);
                    ItemId: "%s";
                }""".formatted(this.iconId));
        anchorBuilder.ensureHeight(100);
    }
}
