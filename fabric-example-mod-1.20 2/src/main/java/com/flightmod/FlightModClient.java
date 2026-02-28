package com.flightmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class FlightModClient implements ClientModInitializer {

    public static KeyBinding flightKey;

    @Override
    public void onInitializeClient() {
        flightKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.flightmod.toggle_flight",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_F,
                "category.flightmod.general"
        ));

        FlightMod.LOGGER.info("FlightMod client initialized. Keybind registered.");
    }
}
