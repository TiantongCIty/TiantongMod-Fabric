package net.fabricmc.tiantong;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import java.io.*;
//import net.minecraft.server.Main;
import net.minecraft.data.Main;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardCriterion;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.TellRawCommand;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.level.storage.LevelStorage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.world.level.LevelInfo;
import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;


public class TiantongMain implements ModInitializer {

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("Tiantong");
	public static final Item Oyster = new Oyster(new FabricItemSettings().maxCount(1));
	//public static final ScoreboardObjective OysterBank = new Scoreboard()
	//		.addObjective("OysterBank", ScoreboardCriterion.DUMMY, Text.empty(), ScoreboardCriterion.RenderType.INTEGER);
	private static final ItemGroup Tiantong = FabricItemGroup.builder(new Identifier("tiantong", "tiantong"))
			.icon(() -> new ItemStack(Oyster))
			.build();
	public static final StairsBlock Iron_Stairs = new StairsBlock(Blocks.IRON_BLOCK.getDefaultState(),FabricBlockSettings.of(Material.METAL));

	@Override
	public void onInitialize() {
		//if()
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		Registry.register(Registries.ITEM, new Identifier("tiantong", "oyster"), Oyster);
		Registry.register(Registries.BLOCK, new Identifier("tiantong", "iron_stairs"), Iron_Stairs);
		ItemGroupEvents.modifyEntriesEvent(Tiantong).register(content -> {
			content.add(Oyster);
			//content.addAfter(Oyster, Iron_Stairs);
		});

		LOGGER.info("Welcome to Tiantong City");
	}
}
