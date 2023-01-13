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
    public static final StairsBlock Iron_Stairs = new StairsBlock(Blocks.IRON_BLOCK.getDefaultState(),FabricBlockSettings.of(Material.METAL));
    public static final void InitBlocks() {
        Registry.register(Registries.BLOCK, new Identifier("tiantong", "iron_stairs"), Iron_Stairs);
    }
}
