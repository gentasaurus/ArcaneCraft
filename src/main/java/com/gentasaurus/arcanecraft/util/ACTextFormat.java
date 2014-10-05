package com.gentasaurus.arcanecraft.util;

import net.minecraft.util.StatCollector;

public class ACTextFormat
{
    public static final String BLACK = "0";
    public static final String DARK_BLUE = "1";
    public static final String DARK_GREEN = "2";
    public static final String DARK_CYAN = "3";
    public static final String DARK_RED = "4";
    public static final String PURPLE = "5";
    public static final String ORANGE = "6";
    public static final String LIGHT_GRAY = "7";
    public static final String GRAY = "8";
    public static final String LIGHT_BLUE = "9";
    public static final String LIGHT_GREEN = "a";
    public static final String LIGHT_CYAN = "b";
    public static final String LIGHT_RED = "c";
    public static final String MAGENTA = "d";
    public static final String YELLOW = "e";
    public static final String WHITE = "f";
    //
    public static final String RANDOM = "k";
    public static final String BOLD = "l";
    public static final String STRIKETHROUGH = "m";
    public static final String UNDERLINED = "n";
    public static final String ITALIC = "o";
    public static final String RESET = "r";

    public static String localize(String string)
    {
        return StatCollector.translateToLocal("text.arcanecraft." + string);
    }
}
