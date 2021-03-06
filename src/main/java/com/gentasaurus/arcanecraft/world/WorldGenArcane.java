package com.gentasaurus.arcanecraft.world;

import com.gentasaurus.arcanecraft.init.ModBlocks;
import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenPumpkin;
import net.minecraft.world.gen.structure.ComponentScatteredFeaturePieces;

import java.util.Random;

public class WorldGenArcane implements IWorldGenerator
{
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
    {
        switch(world.provider.dimensionId)
        {
            case -1: generateNether(world, random, chunkX * 16, chunkZ * 16);
                break;
            case 0: generateSurface(world, random, chunkX * 16, chunkZ * 16);
                break;
            case 1: generateEnd(world, random, chunkX * 16, chunkZ * 16);
                break;
        }
    }

    private void generateEnd(World world, Random random, int x, int z)
    {

    }

    private void generateSurface(World world, Random random, int x, int z)
    {
        BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(x, z);
        if ((biome == BiomesAC.biomeDarkSwamp))
        {
            for (int i = 0; i < 6; i++)
            {
                int j = x + random.nextInt(16) + 8;
                int k = z + random.nextInt(16) + 8;
                int l = random.nextInt(world.getHeightValue(j, k) * 2);
                (new WorldGenPumpkin()).generate(world, random, j, l, k);
            }
        }
        this.addOreSpawn(ModBlocks.arcaniumOre, world, random, x, z, 16, 16, 4 + random.nextInt(2), 18, 5, 70);
    }

    private void generateNether(World world, Random random, int x, int z)
    {

    }


    private void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY)
    {
        for(int i = 0; i < chanceToSpawn; i++)
        {
            int posX = blockXPos + random.nextInt(maxX);
            int posY = minY + random.nextInt(maxY - minY);
            int posZ = blockZPos + random.nextInt(maxZ);
            (new WorldGenMinable(block, maxVeinSize)).generate(world, random, posX, posY, posZ);
        }
    }

}