package com.jarhax.eyespy.api.info;

import com.hypixel.hytale.server.core.ui.builder.UICommandBuilder;

import javax.annotation.Nonnull;

public interface InfoValue {

    InfoValue EMPTY = (_, _, _) -> {
    };

    /**
     * Adds info to the given ui.
     *
     * @param ui            The ui to add info to.
     * @param anchorBuilder A builder to modify the anchor of the ui, useful to auto expand the ui to fit the new content
     * @param selector      The selector that the info should be put within
     */
    void build(@Nonnull UICommandBuilder ui, @Nonnull AnchorBuilder anchorBuilder, String selector);

}
