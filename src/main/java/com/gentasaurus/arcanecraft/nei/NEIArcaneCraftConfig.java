package com.gentasaurus.arcanecraft.nei;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import com.gentasaurus.arcanecraft.reference.Reference;

public class NEIArcaneCraftConfig implements IConfigureNEI {

    @Override
    public void loadConfig() {

        API.registerRecipeHandler(new InfuserRecipeHandler());
        API.registerUsageHandler(new InfuserRecipeHandler());

    }

    @Override
    public String getName() {
        return Reference.modname;
    }

    @Override
    public String getVersion() {
        return Reference.version;
    }
}
