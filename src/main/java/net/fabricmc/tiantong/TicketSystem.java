package net.fabricmc.tiantong;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.realms.Request;
import net.minecraft.client.realms.dto.PlayerInfo;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardCriterion;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.scoreboard.ScoreboardPlayerScore;
import net.minecraft.server.command.TellRawCommand;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraft.world.level.LevelInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TicketSystem {

    public static final String Balance = "OysterBank";
    public static final String Entrance = "Entrance";
    public static final ScoreboardPlayerScore GetScore(World world, PlayerEntity player) {
        Check(world);
        return world.getScoreboard().getPlayerScore(player.getName().toString(), world.getScoreboard().getObjective(Balance));
    }
    public static final boolean Pass(World world, int id, PlayerEntity player) {
        Check(world);
        final ScoreboardPlayerScore En = world.getScoreboard().getPlayerScore(player.getName().toString(), world.getScoreboard().getObjective(Entrance));
        if(id == 0) {
            if(GetScore(world, player).getScore() >= 0) {
                if(En.getScore() == -1) {
                    final ScoreboardPlayerScore Sc = GetScore(world, player);
                    Sc.setScore(Sc.getScore() - 1000);
                }
                return true;
            }
            else
                return false;
        }
        else if(id == 1) {
            boolean PassOut = GetScore(world, player).getScore() >= 20;
            if(PassOut) {
                final ScoreboardPlayerScore Sc = GetScore(world, player);
                Sc.setScore(Sc.getScore() - 20);
            }
            else {
                final ScoreboardPlayerScore Sc = GetScore(world, player);
                Sc.setScore(Sc.getScore() - 50);
            }
            En.setScore(-1);
            return PassOut;
        }
        return false;
    }

    public static final void Check(World world) {
        if(!world.getScoreboard().containsObjective("Balance")) {
            try {
                world.getScoreboard().addObjective(Balance, ScoreboardCriterion.DUMMY, Text.translatable(Balance), ScoreboardCriterion.RenderType.INTEGER);
            }
            catch (Exception Ignored) {
            }
            try {
                world.getScoreboard().addObjective(Entrance, ScoreboardCriterion.DUMMY, Text.translatable(Entrance), ScoreboardCriterion.RenderType.INTEGER);
            }
            catch (Exception Ignored) {
            }
        }
    }
}