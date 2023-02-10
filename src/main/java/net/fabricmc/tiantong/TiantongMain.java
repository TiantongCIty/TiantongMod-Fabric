package net.fabricmc.tiantong;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.tiantong.items.*;
import net.fabricmc.tiantong.blocks.*;

import java.io.IOException;

public class TiantongMain implements ModInitializer {

	public static final Logger LOGGER = LoggerFactory.getLogger("Tiantong");

	public static final ItemGroup Tiantong = FabricItemGroup.builder(new Identifier("tiantong", "tiantong"))
			.icon(() -> new ItemStack(TItems.Oyster))
			.build();

	@Override
	public void onInitialize() {
		TBlocks.InitBlocks();
		TItems.InitItems();
		TiantongConfig.initClass();

		LOGGER.info("Welcome to Tiantong City");
	}
}
