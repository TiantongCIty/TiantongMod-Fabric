package net.fabricmc.tiantong.blocks;

import net.fabricmc.tiantong.TicketSystem;
import net.fabricmc.tiantong.items.TItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.mob.IllagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.scoreboard.ScoreboardPlayerScore;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockStateRaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.tick.Tick;
import net.minecraft.world.tick.TickPriority;
import org.apache.logging.log4j.core.config.Property;

import java.util.Comparator;
import java.util.Objects;
import java.util.Properties;

import static com.ibm.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class TicketBarrier extends Block {
    public static final DirectionProperty FACING = DirectionProperty.of("facing");
    public static final BooleanProperty EXIT = BooleanProperty.of("exit");
    public static final BooleanProperty OPEN = BooleanProperty.of("open");

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(EXIT);
        builder.add(OPEN);
    }
    boolean isExit = false;
    public TicketBarrier(Settings settings, boolean isExit) {
        super(settings);
        this.isExit = isExit;
        setDefaultState(getDefaultState().with(OPEN, false));
        setDefaultState(getDefaultState().with(EXIT, isExit));
    }

    public static ScoreboardPlayerScore GetScore(World world, PlayerEntity player) {
        return world.getScoreboard().getPlayerScore(player.getName().toString(), world.getScoreboard().getObjective("Entrance"));
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        String Name = state.getBlock().getName().toString();
        if(player.getHandItems() == TItems.Oyster) {
            boolean Pass = TicketSystem.Pass(world, isExit ? 1 : 0 , player);
            if(Pass)
                world.setBlockState(pos, state.with(OPEN, true));
            else
                world.setBlockState(pos, state.with(OPEN, false));
        }
        return ActionResult.SUCCESS;
    }
    public boolean isOpen(BlockState state) {
        return state.get(OPEN);
    }
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        Tick tick = new Tick(this, pos,0, TickPriority.HIGH);
        if(isOpen(state))
            tick.createOrderedTick(2000, 5);
        if(!isOpen(state))
            return;
        final Direction facing = state.get(FACING);
        if(!world.isClient() && entity instanceof PlayerEntity) {
            final Vec3d playerPos = entity.getPos().subtract(pos.getX() + 0.5, 0, pos.getZ() + 0.5).rotateY((float) Math.toRadians(facing.rotateYCounterclockwise().asRotation()));
            if(isOpen(state) && playerPos.z > 0)
                world.setBlockState(pos, state.with(OPEN, false));
        }
        world.setBlockState(pos, state.with(OPEN, false));
    }
}
