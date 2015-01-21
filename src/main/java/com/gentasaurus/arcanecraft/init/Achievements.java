package com.gentasaurus.arcanecraft.init;

import net.minecraft.init.Blocks;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class Achievements
{

    public static Achievement achievementDarkSwamp;

    public static void init()
    {
        achievementDarkSwamp = new Achievement("achievement.darkSwamp", "darkSwamp", 0, -2, Blocks.pumpkin, null).initIndependentStat().registerStat();

        AchievementPage.registerAchievementPage(new AchievementPage("ArcaneCraft", new Achievement[]{achievementDarkSwamp}));
    }

}
