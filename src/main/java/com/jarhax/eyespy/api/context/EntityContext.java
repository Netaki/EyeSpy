package com.jarhax.eyespy.api.context;

import com.hypixel.hytale.component.ArchetypeChunk;
import com.hypixel.hytale.component.CommandBuffer;
import com.hypixel.hytale.component.Ref;
import com.hypixel.hytale.component.Store;
import com.hypixel.hytale.server.core.entity.entities.Player;
import com.hypixel.hytale.server.core.modules.entity.component.TransformComponent;
import com.hypixel.hytale.server.core.universe.world.chunk.WorldChunk;
import com.hypixel.hytale.server.core.universe.world.storage.EntityStore;
import com.hypixel.hytale.server.core.util.TargetUtil;

import javax.annotation.Nullable;

public class EntityContext extends Context {

    private final Ref<EntityStore> entity;

    public EntityContext(float delta, int index, ArchetypeChunk<EntityStore> archetypeChunk, Store<EntityStore> store, CommandBuffer<EntityStore> commandBuffer, Player observer, WorldChunk chunk, Ref<EntityStore> entity) {
        super(delta, index, archetypeChunk, store, commandBuffer, observer, chunk);
        this.entity = entity;
    }

    public Ref<EntityStore> entity() {
        return entity;
    }

    @Nullable
    public static EntityContext create(Player player, float dt, int index, ArchetypeChunk<EntityStore> archetypeChunk, Store<EntityStore> store, CommandBuffer<EntityStore> commandBuffer) {

        final Ref<EntityStore> targetEntity = TargetUtil.getTargetEntity(archetypeChunk.getReferenceTo(index), commandBuffer);
        final TransformComponent transform = archetypeChunk.getComponent(index, TransformComponent.getComponentType());
        if (transform != null && targetEntity != null) {
            final WorldChunk chunk = transform.getChunk();
            return new EntityContext(dt, index, archetypeChunk, store, commandBuffer, player, chunk, targetEntity);
        }

        return null;
    }
}
