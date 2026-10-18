package com.enderdevelopment.autoplacer.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.client.MinecraftClient;

public class AutoPlacerClient implements ClientModInitializer {
    private AutoPlacer autoPlacer;

    @Override
    public void onInitializeClient() {
        MinecraftClient client = MinecraftClient.getInstance();
        autoPlacer = new AutoPlacer(client);

        ClientTickEvents.END_CLIENT_TICK.register(clientInstance -> {
            if (clientInstance.player != null) {
                autoPlacer.tick();
            }
        });
    }

    public AutoPlacer getAutoPlacer() {
        return autoPlacer;
    }
}