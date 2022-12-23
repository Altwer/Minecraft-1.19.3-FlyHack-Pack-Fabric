package net.fabricmc.flyhack;

import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.entity.Entity;
import net.minecraft.util.ActionResult;
import net.minecraft.entity.damage.DamageSource;
import net.fabricmc.fabric.api.event.Event;


public interface EntityDamageCallback {
    Event<EntityDamageCallback> EVENT = EventFactory.createArrayBacked(EntityDamageCallback.class, (listeners) -> (entity, source, amount) -> {
        for(EntityDamageCallback listener : listeners) {
            ActionResult result = listener.interact(entity, source, amount);
            if (result != ActionResult.PASS) {
                return result;
            }
        }

        return ActionResult.PASS;
    });

    ActionResult interact(Entity entity, DamageSource source, float amount);
}