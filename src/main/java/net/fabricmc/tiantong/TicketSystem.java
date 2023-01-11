package net.fabricmc.tiantong;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.realms.Request;
import net.minecraft.client.realms.dto.PlayerInfo;
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
    public static final ScoreboardPlayerScore GetScore(World world, PlayerInfo player) {
        return world.getScoreboard().getPlayerScore(player.getName(), world.getScoreboard().getObjective(Balance));
    }
    public static final boolean Pass(World world, int id, PlayerInfo player) {
        if(id == 0) {
            if(GetScore(world, player).getScore() >= 0) {

                return true;
            }
            else
                return false;
        }
        else if(id == 1) {
            if(GetScore(world, player).getScore() >= 20)
                return true;
            else
                return false;
        }
        return false;
    }
}