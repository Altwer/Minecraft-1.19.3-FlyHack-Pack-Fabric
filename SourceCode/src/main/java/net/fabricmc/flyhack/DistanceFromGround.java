package net.fabricmc.flyhack;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.block.BlockState;
import net.minecraft.world.World;
import net.minecraft.client.MinecraftClient;

public class DistanceFromGround {
    static World world = MinecraftClient.getInstance().world;
    public static int getDistance(Entity e) {
        BlockState state;
        Vec3d loc = e.getPos();
        double y = e.getBlockY();
        BlockPos pos = new BlockPos(loc);
        int distance = 0;
        while(world.getBlockState(pos).isAir()) {
            pos.add(0,-1,0);
            distance++;
        }
        return distance;
    }
}
