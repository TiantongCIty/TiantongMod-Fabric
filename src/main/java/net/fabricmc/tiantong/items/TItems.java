package net.fabricmc.tiantong.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.fabricmc.tiantong.blocks.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.fabricmc.tiantong.TiantongMain.Tiantong;

public class TItems {
    public static final Item Oyster = new Oyster(new FabricItemSettings().maxCount(1));
    public static final Item Iron_Stairs = new BlockItem(TBlocks.Iron_Stairs, new FabricItemSettings());
    public static final Item Black_Concrete_Stairs = new BlockItem(TBlocks.Black_Concrete_Stairs, new FabricItemSettings());
    public static final Item White_Concrete_Stairs = new BlockItem(TBlocks.White_Concrete_Stairs, new FabricItemSettings());
    public static final Item Blue_Concrete_Stairs = new BlockItem(TBlocks.Blue_Concrete_Stairs, new FabricItemSettings());
    public static final Item Cyan_Concrete_Stairs = new BlockItem(TBlocks.Cyan_Concrete_Stairs, new FabricItemSettings());
    public static final Item Green_Concrete_Stairs = new BlockItem(TBlocks.Gray_Concrete_Stairs, new FabricItemSettings());
    public static final Item Lime_Concrete_Stairs = new BlockItem(TBlocks.Lime_Concrete_Stairs, new FabricItemSettings());
    public static final Item Magenta_Concrete_Stairs = new BlockItem(TBlocks.Magenta_Concrete_Stairs, new FabricItemSettings());
    public static final Item Brown_Concrete_Stairs = new BlockItem(TBlocks.Brown_Concrete_Stairs, new FabricItemSettings());
    public static final Item Gray_Concrete_Stairs = new BlockItem(TBlocks.Gray_Concrete_Stairs, new FabricItemSettings());
    public static final Item Orange_Concrete_Stairs = new BlockItem(TBlocks.Orange_Concrete_Stairs, new FabricItemSettings());
    public static final Item Pink_Concrete_Stairs = new BlockItem(TBlocks.Pink_Concrete_Stairs, new FabricItemSettings());
    public static final Item Red_Concrete_Stairs = new BlockItem(TBlocks.Red_Concrete_Stairs, new FabricItemSettings());
    public static final Item Purple_Concrete_Stairs = new BlockItem(TBlocks.Purple_Concrete_Stairs, new FabricItemSettings());
    public static final Item Yellow_Concrete_Stairs = new BlockItem(TBlocks.Yellow_Concrete_Stairs, new FabricItemSettings());
    public static final Item Light_Blue_Concrete_Stairs = new BlockItem(TBlocks.Light_Blue_Concrete_Stairs, new FabricItemSettings());
    public static final Item Light_Gray_Concrete_Stairs = new BlockItem(TBlocks.Light_Gray_Concrete_Stairs, new FabricItemSettings());
    public static final void InitItems() {
        Registry.register(Registries.ITEM, new Identifier("tiantong", "oyster"), Oyster);
        Registry.register(Registries.ITEM, new Identifier("tiantong", "iron_stairs"), Iron_Stairs);
        Registry.register(Registries.ITEM, new Identifier("tiantong", "black_concrete_stairs"), Black_Concrete_Stairs);
        Registry.register(Registries.ITEM, new Identifier("tiantong", "blue_concrete_stairs"), Blue_Concrete_Stairs);
        Registry.register(Registries.ITEM, new Identifier("tiantong", "brown_concrete_stairs"), Brown_Concrete_Stairs);
        Registry.register(Registries.ITEM, new Identifier("tiantong", "light_blue_concrete_stairs"), Light_Blue_Concrete_Stairs);
        Registry.register(Registries.ITEM, new Identifier("tiantong", "light_gray_concrete_stairs"), Light_Gray_Concrete_Stairs);
        Registry.register(Registries.ITEM, new Identifier("tiantong", "lime_concrete_stairs"), Lime_Concrete_Stairs);
        Registry.register(Registries.ITEM, new Identifier("tiantong", "red_concrete_stairs"), Red_Concrete_Stairs);
        Registry.register(Registries.ITEM, new Identifier("tiantong", "pink_concrete_stairs"), Pink_Concrete_Stairs);
        Registry.register(Registries.ITEM, new Identifier("tiantong", "purple_concrete_stairs"), Purple_Concrete_Stairs);
        Registry.register(Registries.ITEM, new Identifier("tiantong", "yellow_concrete_stairs"), Yellow_Concrete_Stairs);
        Registry.register(Registries.ITEM, new Identifier("tiantong", "white_concrete_stairs"), White_Concrete_Stairs);
        Registry.register(Registries.ITEM, new Identifier("tiantong", "cyan_concrete_stairs"), Cyan_Concrete_Stairs);
        Registry.register(Registries.ITEM, new Identifier("tiantong", "gray_concrete_stairs"), Gray_Concrete_Stairs);
        Registry.register(Registries.ITEM, new Identifier("tiantong", "green_concrete_stairs"), Green_Concrete_Stairs);
        Registry.register(Registries.ITEM, new Identifier("tiantong", "magenta_concrete_stairs"), Magenta_Concrete_Stairs);
        Registry.register(Registries.ITEM, new Identifier("tiantong", "orange_concrete_stairs"), Orange_Concrete_Stairs);
        ItemGroupEvents.modifyEntriesEvent(Tiantong).register(content -> {
            content.add(Oyster);
            content.addAfter(Oyster, Iron_Stairs);
            content.addAfter(Iron_Stairs, White_Concrete_Stairs);
            content.addAfter(White_Concrete_Stairs, Light_Gray_Concrete_Stairs);
            content.addAfter(Light_Gray_Concrete_Stairs, Gray_Concrete_Stairs);
            content.addAfter(Gray_Concrete_Stairs, Black_Concrete_Stairs);
            content.addAfter(Black_Concrete_Stairs, Brown_Concrete_Stairs);
            content.addAfter(Brown_Concrete_Stairs, Red_Concrete_Stairs);
            content.addAfter(Red_Concrete_Stairs, Orange_Concrete_Stairs);
            content.addAfter(Orange_Concrete_Stairs, Yellow_Concrete_Stairs);
            content.addAfter(Yellow_Concrete_Stairs, Lime_Concrete_Stairs);
            content.addAfter(Lime_Concrete_Stairs, Green_Concrete_Stairs);
            content.addAfter(Green_Concrete_Stairs, Cyan_Concrete_Stairs);
            content.addAfter(Cyan_Concrete_Stairs, Light_Blue_Concrete_Stairs);
            content.addAfter(Light_Blue_Concrete_Stairs, Blue_Concrete_Stairs);
            content.addAfter(Blue_Concrete_Stairs, Purple_Concrete_Stairs);
            content.addAfter(Purple_Concrete_Stairs, Magenta_Concrete_Stairs);
            content.addAfter(Magenta_Concrete_Stairs, Pink_Concrete_Stairs);
        });
    }
}
