package net.fabricmc.tiantong.items;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.fabricmc.tiantong.blocks.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.fabricmc.tiantong.TiantongMain.Tiantong;

public class TItems {
    public static final Item Oyster = new Oyster(new FabricItemSettings().maxCount(1));
    public static final Item Iron_Stiars_Item = new BlockItem(TBlocks.Iron_Stairs, new FabricItemSettings());
    public static final void InitItems() {
        Registry.register(Registries.ITEM, new Identifier("tiantong", "oyster"), Oyster);
        Registry.register(Registries.ITEM, new Identifier("tiantong", "iron_stairs"), Iron_Stiars_Item);
        ItemGroupEvents.modifyEntriesEvent(Tiantong).register(content -> {
            content.add(TItems.Oyster);
            content.addAfter(TItems.Oyster, Iron_Stiars_Item);
        });
    }
}
