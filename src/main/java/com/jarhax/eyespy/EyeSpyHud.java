package com.jarhax.eyespy;

import com.hypixel.hytale.component.ArchetypeChunk;
import com.hypixel.hytale.component.CommandBuffer;
import com.hypixel.hytale.component.Holder;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.protocol.FormattedMessage;
import com.hypixel.hytale.server.core.Message;
import com.hypixel.hytale.server.core.entity.EntityUtils;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.entity.entities.player.hud.CustomUIHud;
import com.hypixel.hytale.server.core.ui.builder.UICommandBuilder;
import com.hypixel.hytale.server.core.universe.PlayerRef;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import com.jarhax.eyespy.api.InfoProvider;
import com.jarhax.eyespy.api.context.BlockContext;
import com.jarhax.eyespy.api.info.InfoBuilder;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.LinkedList;
import java.util.List;

public class EyeSpyHud extends CustomUIHud {

    // TODO Allow plugins to register new providers;
    private static final List<InfoProvider<BlockContext, InfoBuilder>> blockInfoProviders = new LinkedList<>();

    static {
        blockInfoProviders.add(new VanillaBlockInfoProvider());
    }

    private InfoBuilder info;

    public EyeSpyHud(@Nonnull PlayerRef playerRef) {
        super(playerRef);
    }

    public void updateHud(float dt, int index, @Nonnull ArchetypeChunk<EntityStore> archetypeChunk, @Nonnull Store<EntityStore> store, @Nonnull CommandBuffer<EntityStore> commandBuffer) {
        info = new InfoBuilder();
        final Holder<EntityStore> holder = EntityUtils.toHolder(index, archetypeChunk);
        final Player player = holder.getComponent(Player.getComponentType());
        if (player != null && player.getWorld() != null) {
            final BlockContext blockContext = BlockContext.create(player, dt, index, archetypeChunk, store, commandBuffer);
            if (blockContext != null) {
                for (InfoProvider<BlockContext, InfoBuilder> provider : blockInfoProviders) {
                    provider.updateDescription(blockContext, info);
                }
            }
        }
    }

    @Override
    protected void build(@Nonnull UICommandBuilder commandBuilder) {
        if (info != null) {
            commandBuilder.append("Hud/EyeSpy.ui");
            setText(commandBuilder, "#Header", this.info.getHeader());
            setText(commandBuilder, "#Body", this.info.getBody());
            setText(commandBuilder, "#Footer", this.info.getFooter());
            setIcon(commandBuilder, this.info.getIcon());
        }
    }

    @Override
    public void update(boolean clear, @Nonnull UICommandBuilder commandBuilder) {
        super.update(clear, commandBuilder);
    }

    private static boolean isValid(Message message) {
        if (message != null) {
            final FormattedMessage formattedMessage = message.getFormattedMessage();
            return formattedMessage != null;
        }
        return false;
    }

    private void setText(@Nonnull UICommandBuilder commandBuilder, @Nonnull String selector, @Nullable Message value) {
        if (!isValid(value)) {
            commandBuilder.set(selector + ".Visible", false);
        }
        else {
            commandBuilder.set(selector + ".Visible", true);
            commandBuilder.set(selector + ".TextSpans", value);
        }
    }

    private void setIcon(@Nonnull UICommandBuilder commandBuilder, @Nullable String iconId) {
        if (iconId == null) {
            commandBuilder.set("#Icon.Visible", false);
        }
        else {
            commandBuilder.set("#Icon.Visible", true);
            commandBuilder.set("#Icon.ItemId", this.info.getIcon());
        }
    }
}
