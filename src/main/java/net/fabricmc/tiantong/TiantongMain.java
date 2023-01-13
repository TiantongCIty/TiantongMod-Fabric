package net.fabricmc.tiantong;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.tiantong.items.Oyster;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
//import net.minecraft.server.Main;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.tiantong.items.*;
import net.fabricmc.tiantong.blocks.*;


public class TiantongMain implements ModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger("Tiantong");

	public static final ItemGroup Tiantong = FabricItemGroup.builder(new Identifier("tiantong", "tiantong"))
			.icon(() -> new ItemStack(TItems.Oyster))
			.build();

	@Override
	public void onInitialize() {
		TBlocks.InitBlocks();
		TItems.InitItems();
		LOGGER.info("Welcome to Tiantong City");
	}
}
