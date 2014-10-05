package com.gentasaurus.arcanecraft.world;

import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenSwamp;

public class BiomeDarkSwamp extends BiomeGenSwamp
{

    private static final Height biomeHeight = new Height(0.1F, 0.2F);
    private int darkPurple = 3214671;
    private int orange = 14914560;
    private int darkCyan = 1397307;

    public BiomeDarkSwamp(int id)
    {
        super(id);
        this.setHeight(biomeHeight);
        this.setColor(darkPurple);
        this.setTemperatureRainfall(0.6F, 0.0F);
        this.waterColorMultiplier = darkCyan;
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityWitch.class, 100, 5, 20));
    }

    @Override
    public int getBiomeGrassColor(int x, int y, int z)
    {
        return darkPurple;
    }

    @Override
    public int getBiomeFoliageColor(int x, int y, int z)
    {
        return orange;
    }

    @Override
    public int getSkyColorByTemp(float par1)
    {
        return 0;
    }
}
