package com.flightmod;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlightMod implements ModInitializer {

    public static final String MOD_ID = "flightmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("FlightMod loaded! Press F to toggle survival flight.");
    }
}
