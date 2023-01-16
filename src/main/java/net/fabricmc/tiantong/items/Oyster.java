package net.fabricmc.tiantong.items;

import com.mojang.brigadier.exceptions.Dynamic3CommandExceptionType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.tiantong.TiantongMain;
import net.minecraft.block.Blocks;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardPlayerScore;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.command.TitleCommand;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.fabricmc.tiantong.mixin.TiantongMixin;

import java.util.Set;

import static net.fabricmc.tiantong.TicketSystem.Check;

public class Oyster extends Item {
    public Oyster(Settings settings) {
		super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        Check(world);
        int TScore = 0;
        boolean IsCharged = false;
        if(playerEntity.getInventory().containsAny(Set.of(Items.EMERALD))) {
            for (var v : playerEntity.getInventory().main) {
                if (v.getItem() == Items.EMERALD) {
                    TiantongMain.LOGGER.info("Charging");
                    TScore = TScore + v.getCount();
                    v.setCount(0);
                    TiantongMain.LOGGER.info("Successful");
                    IsCharged = true;
                }
            }
        }

        if(playerEntity.getInventory().containsAny(Set.of(Blocks.EMERALD_BLOCK.asItem()))) {
            for (var v : playerEntity.getInventory().main) {
                if(v.getItem() == Blocks.EMERALD_BLOCK.asItem()) {
                    TiantongMain.LOGGER.info("Charging");
                    TScore = TScore + v.getCount() * 9;
                    v.setCount(0);
                    TiantongMain.LOGGER.info("Successful");
                    IsCharged = true;
                }
            }
        }
        final ScoreboardPlayerScore Sc = world.getScoreboard().getPlayerScore(playerEntity.getName().getString(), world.getScoreboard().getObjective("OysterBank"));
        int Score = Sc.getScore() + TScore;
        Sc.setScore(Score);
        if(IsCharged)
            playerEntity.sendMessage(Text.translatable("gui.tiantong.charge", String.format("%d", TScore)), true);
        else
            playerEntity.sendMessage(Text.translatable("gui.tiantong.balance",  String.format("%d", Sc.getScore())), true);
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}