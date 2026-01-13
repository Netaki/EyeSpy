package com.jarhax.eyespy.api.info.values;

import com.hypixel.hytale.server.core.ui.builder.UICommandBuilder;
import com.jarhax.eyespy.api.info.AnchorBuilder;
import com.jarhax.eyespy.api.info.InfoValue;

import javax.annotation.Nonnull;

public class ProgressBarValue implements InfoValue {

    private final String id;
    private final float value;

    public ProgressBarValue(String id, float value) {
        this.id = id;
        this.value = Math.clamp(value, 0, 1);
    }

    @Override
    public void build(@Nonnull UICommandBuilder ui, @Nonnull AnchorBuilder anchorBuilder, String selector) {
        ui.appendInline(selector, """
                Group {
                  Anchor: (Height: 12);
                  Background: "Hud/EyeSpy/ProcessingBar.png";
                
                  ProgressBar #%s {
                    Value: %s;
                    BarTexturePath: "Hud/EyeSpy/ProcessingBarFill.png";
                    EffectTexturePath: "Hud/EyeSpy/ProcessingBarEffect.png";
                    EffectWidth: 102;
                    EffectHeight: 58;
                    EffectOffset: 74;
                  }
                }""".formatted(this.id, this.value));
        anchorBuilder.addHeight(12);

    }
}
