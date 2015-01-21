package com.gentasaurus.arcanecraft.item;

import java.util.Random;

public class ItemArcaneWrench extends ItemGeneric
{
    protected Random random = new Random();

    public ItemArcaneWrench()
    {
        super();
        this.setFull3D();
        this.setMaxStackSize(1);
    }

}
