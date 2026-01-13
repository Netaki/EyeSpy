package com.jarhax.eyespy.api.info.values;

import com.hypixel.hytale.server.core.ui.builder.UICommandBuilder;
import com.jarhax.eyespy.api.info.AnchorBuilder;
import com.jarhax.eyespy.api.info.InfoValue;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;

import javax.annotation.Nonnull;
import java.util.List;

public class GroupValue implements InfoValue {

    private final String id;
    private final List<InfoValue> values;

    public GroupValue(String id, List<InfoValue> values) {
        this.id = id;
        this.values = values;
    }

    @Override
    public void build(@NonNullDecl UICommandBuilder ui, @Nonnull AnchorBuilder anchorBuilder, String selector) {
        ui.appendInline(selector, """
                Group #%s {
                    LayoutMode: Top;
                }""".formatted(this.id));
        for (InfoValue value : values) {
            value.build(ui, anchorBuilder, "#" + id);
        }
    }
}
