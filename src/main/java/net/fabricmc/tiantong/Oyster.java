package net.fabricmc.tiantong;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardPlayerScore;
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
        if(playerEntity.getInventory().containsAny(Set.of(Items.EMERALD))) {
            for (var v : playerEntity.getInventory().main) {
                if (v.getItem() == Items.EMERALD) {
                    TiantongMain.LOGGER.info("Charging");
                    final ScoreboardPlayerScore Sc = world.getScoreboard().getPlayerScore(playerEntity.getName().getString(), world.getScoreboard().getObjective("OysterBank"));
                    int Score = Sc.getScore() + v.getCount();
                    v.setCount(0);
                    Sc.setScore(Score);
                    TiantongMain.LOGGER.info("Successful");
                }
            }
        }
        if(playerEntity.getInventory().containsAny(Set.of(Blocks.EMERALD_BLOCK.asItem()))) {
            for (var v : playerEntity.getInventory().main) {
                if(v.getItem() == Blocks.EMERALD_BLOCK.asItem()) {
                    TiantongMain.LOGGER.info("Charging");
                    final ScoreboardPlayerScore Sc = world.getScoreboard().getPlayerScore(playerEntity.getName().getString(), world.getScoreboard().getObjective("OysterBank"));
                    int Score = Sc.getScore() + v.getCount() * 9;
                    v.setCount(0);
                    Sc.setScore(Score);
                    TiantongMain.LOGGER.info("Successful");
                }
            }
        }
        return TypedActionResult.success(playerEntity.getStackInHand(hand));
    }
}