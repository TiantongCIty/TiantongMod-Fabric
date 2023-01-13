package net.fabricmc.tiantong.blocks;

//import net.minecraft.server.Main;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.block.StairsBlock;
import net.fabricmc.tiantong.items.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.fabricmc.tiantong.TiantongMain.Tiantong;

public class TBlocks {
    public static final StairsBlock Iron_Stairs = new StairsBlock(Blocks.IRON_BLOCK.getDefaultState(), FabricBlockSettings.of(Material.METAL));
    public static final StairsBlock Black_Concrete_Stairs = new StairsBlock(Blocks.BLACK_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.BLACK_CONCRETE));
    public static final StairsBlock White_Concrete_Stairs = new StairsBlock(Blocks.WHITE_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.WHITE_CONCRETE));
    public static final StairsBlock Blue_Concrete_Stairs = new StairsBlock(Blocks.BLUE_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.BLUE_CONCRETE));
    public static final StairsBlock Cyan_Concrete_Stairs = new StairsBlock(Blocks.CYAN_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.CYAN_CONCRETE));
    public static final StairsBlock Green_Concrete_Stairs = new StairsBlock(Blocks.GREEN_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.GREEN_CONCRETE));
    public static final StairsBlock Lime_Concrete_Stairs = new StairsBlock(Blocks.LIME_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.LIME_CONCRETE));
    public static final StairsBlock Magenta_Concrete_Stairs = new StairsBlock(Blocks.MAGENTA_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.MAGENTA_CONCRETE));
    public static final StairsBlock Brown_Concrete_Stairs = new StairsBlock(Blocks.BROWN_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.BROWN_CONCRETE));
    public static final StairsBlock Gray_Concrete_Stairs = new StairsBlock(Blocks.GRAY_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.GRAY_CONCRETE));
    public static final StairsBlock Orange_Concrete_Stairs = new StairsBlock(Blocks.ORANGE_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.ORANGE_CONCRETE));
    public static final StairsBlock Pink_Concrete_Stairs = new StairsBlock(Blocks.PINK_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.PINK_CONCRETE));
    public static final StairsBlock Red_Concrete_Stairs = new StairsBlock(Blocks.RED_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.RED_CONCRETE));
    public static final StairsBlock Purple_Concrete_Stairs = new StairsBlock(Blocks.PURPLE_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.PURPLE_CONCRETE));
    public static final StairsBlock Yellow_Concrete_Stairs = new StairsBlock(Blocks.YELLOW_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.YELLOW_CONCRETE));
    public static final StairsBlock Light_Blue_Concrete_Stairs = new StairsBlock(Blocks.LIGHT_BLUE_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.LIGHT_BLUE_CONCRETE));
    public static final StairsBlock Light_Gray_Concrete_Stairs = new StairsBlock(Blocks.LIGHT_GRAY_CONCRETE.getDefaultState(), FabricBlockSettings.copyOf(Blocks.LIGHT_GRAY_CONCRETE));

    public static final void InitBlocks() {
        Registry.register(Registries.BLOCK, new Identifier("tiantong", "iron_stairs"), Iron_Stairs);
        Registry.register(Registries.BLOCK, new Identifier("tiantong", "black_concrete_stairs"), Black_Concrete_Stairs);
        Registry.register(Registries.BLOCK, new Identifier("tiantong", "blue_concrete_stairs"), Blue_Concrete_Stairs);
        Registry.register(Registries.BLOCK, new Identifier("tiantong", "brown_concrete_stairs"), Brown_Concrete_Stairs);
        Registry.register(Registries.BLOCK, new Identifier("tiantong", "light_blue_concrete_stairs"), Light_Blue_Concrete_Stairs);
        Registry.register(Registries.BLOCK, new Identifier("tiantong", "light_gray_concrete_stairs"), Light_Gray_Concrete_Stairs);
        Registry.register(Registries.BLOCK, new Identifier("tiantong", "lime_concrete_stairs"), Lime_Concrete_Stairs);
        Registry.register(Registries.BLOCK, new Identifier("tiantong", "red_concrete_stairs"), Red_Concrete_Stairs);
        Registry.register(Registries.BLOCK, new Identifier("tiantong", "pink_concrete_stairs"), Pink_Concrete_Stairs);
        Registry.register(Registries.BLOCK, new Identifier("tiantong", "purple_concrete_stairs"), Purple_Concrete_Stairs);
        Registry.register(Registries.BLOCK, new Identifier("tiantong", "yellow_concrete_stairs"), Yellow_Concrete_Stairs);
        Registry.register(Registries.BLOCK, new Identifier("tiantong", "white_concrete_stairs"), White_Concrete_Stairs);
        Registry.register(Registries.BLOCK, new Identifier("tiantong", "cyan_concrete_stairs"), Cyan_Concrete_Stairs);
        Registry.register(Registries.BLOCK, new Identifier("tiantong", "gray_concrete_stairs"), Gray_Concrete_Stairs);
        Registry.register(Registries.BLOCK, new Identifier("tiantong", "green_concrete_stairs"), Green_Concrete_Stairs);
        Registry.register(Registries.BLOCK, new Identifier("tiantong", "magenta_concrete_stairs"), Magenta_Concrete_Stairs);
        Registry.register(Registries.BLOCK, new Identifier("tiantong", "orange_concrete_stairs"), Orange_Concrete_Stairs);
    }
}
