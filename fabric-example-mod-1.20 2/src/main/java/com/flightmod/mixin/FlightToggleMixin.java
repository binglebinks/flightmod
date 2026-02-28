package com.flightmod.mixin;

import com.flightmod.FlightModClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerAbilities;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class FlightToggleMixin {

    @Inject(at = @At("HEAD"), method = "tick")
    private void onTick(CallbackInfo info) {
        MinecraftClient client = MinecraftClient.getInstance();
        ClientPlayerEntity player = client.player;

        if (player == null) return;

        while (FlightModClient.flightKey.wasPressed()) {
            PlayerAbilities abilities = player.getAbilities();

            abilities.allowFlying = !abilities.allowFlying;

            if (!abilities.allowFlying) {
                abilities.flying = false;
            }

            player.sendAbilitiesUpdate();

            if (abilities.allowFlying) {
                player.sendMessage(
                    net.minecraft.text.Text.literal("§aFlight Enabled"),
                    true
                );
            } else {
                player.sendMessage(
                    net.minecraft.text.Text.literal("§cFlight Disabled"),
                    true
                );
            }
        }
    }
}
