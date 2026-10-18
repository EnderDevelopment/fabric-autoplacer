package com.enderdevelopment.autoplacer.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class AutoPlacer {
    private final MinecraftClient client;
    private int horizontalRadius;
    private int verticalHeight;
    private int blocksPerTick;
    private boolean rotateEnabled;

    public AutoPlacer(MinecraftClient client) {
        this.client = client;
    }

    public void setConfig(int horizontalRadius, int verticalHeight, int blocksPerTick, boolean rotateEnabled) {
        this.horizontalRadius = horizontalRadius;
        this.verticalHeight = verticalHeight;
        this.blocksPerTick = blocksPerTick;
        this.rotateEnabled = rotateEnabled;
    }

    public void tick() {
        ClientPlayerEntity player = client.player;
        if (player == null) return;

        World world = player.getWorld();
        BlockPos playerPos = player.getBlockPos();

        int blocksPlaced = 0;
        for (int x = -horizontalRadius; x <= horizontalRadius; x++) {
            for (int y = -verticalHeight; y <= verticalHeight; y++) {
                for (int z = -horizontalRadius; z <= horizontalRadius; z++) {
                    BlockPos pos = playerPos.add(x, y, z);
                    if (world.isAir(pos) || world.getBlockState(pos).getMaterial().isReplaceable()) {
                        if (rotateEnabled) {
                            Direction direction = Direction.getFacing(x, y, z);
                            player.setYaw(direction.asRotation());
                        }
                        player.interactionManager.interactBlock(player, player.getActiveHand(), pos, Direction.getFacing(x, y, z), 0.5f, 0.5f, 0.5f);
                        blocksPlaced++;
                        if (blocksPlaced >= blocksPerTick) return;
                    }
                }
            }
        }
    }
}