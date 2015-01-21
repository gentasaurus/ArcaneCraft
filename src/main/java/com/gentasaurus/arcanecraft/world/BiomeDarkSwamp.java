package com.gentasaurus.arcanecraft.world;

import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.BiomeGenSwamp;

public class BiomeDarkSwamp extends BiomeGenSwamp
{

    private int grassColor = 3214671; //Dark Purple
    private int foilageColor = 16741120; //Orange
    private int waterColor = 1397307; //Dark Cyan

    public BiomeDarkSwamp(int id)
    {
        super(id);
        this.setHeight(BiomeGenBase.height_PartiallySubmerged);
        this.setColor(grassColor);
        this.setTemperatureRainfall(0.6F, 0.0F);
        this.waterColorMultiplier = waterColor;
        this.spawnableMonsterList.add(new BiomeGenBase.SpawnListEntry(EntityWitch.class, 100, 5, 20));
    }

    @Override
    public int getBiomeGrassColor(int x, int y, int z)
    {
        return grassColor;
    }

    @Override
    public int getBiomeFoliageColor(int x, int y, int z)
    {
        return foilageColor;
    }

    @Override
    public int getSkyColorByTemp(float par1)
    {
        return 0;
    }
}
