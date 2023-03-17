package net.fabricmc.tiantong.blocks;

import net.fabricmc.tiantong.TicketSystem;
import net.fabricmc.tiantong.items.TItems;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.control.JumpControl;
import net.minecraft.entity.mob.IllagerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.scoreboard.ScoreboardPlayerScore;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.*;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockStateRaycastContext;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.gen.carver.RavineCarverConfig;
import net.minecraft.world.tick.Tick;
import net.minecraft.world.tick.TickPriority;
import org.apache.logging.log4j.core.config.Property;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Comparator;
import java.util.Objects;
import java.util.Properties;

import static com.ibm.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class TicketBarrier extends Block {
    //final Block block = new Block(Settings.of(Material.AIR));
    public static final DirectionProperty FACING = DirectionProperty.of("facing");
    public static final BooleanProperty OPEN = BooleanProperty.of("open");    //public static final BooleanProperty EXIT = BooleanProperty.of("exit");
    protected static final VoxelShape DOOR_CLOSE = VoxelShapes.union(VoxelShapes.cuboid(0.625f, 0.125f, 0.0625f, 0.6875f, 0.8125f, 0.34375f), VoxelShapes.cuboid(0.625f, 0.125f, 0.46875f, 0.6875f, 0.8125f, 0.75));
    protected static final VoxelShape BASE = VoxelShapes.union(VoxelShapes.cuboid(-0.25f, 0f, 0f, 1.25f, 1.25f, 0.125f), VoxelShapes.cuboid(-0.25f, 0f, 0.8125f, 1.25f, 1.25f, 1f));
    protected static final VoxelShape OPENED = VoxelShapes.union(BASE, BASE, BASE);
    protected static final VoxelShape CLOSED = VoxelShapes.union(BASE, DOOR_CLOSE);

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        //builder.add(EXIT);
        builder.add(OPEN);
    }
    @Nullable
    protected VoxelShape initShape(BlockState state) {
        Direction facing = state.get(FACING);
        boolean isOpen = state.get(OPEN);
        if(!isOpen)
            return VoxelShapes.union(
                    getVSBD(getSBP(-4, 0, 0, 5, 16, 1), facing),
                    getVSBD(getSBP(14, 0, 0, 20, 16, 1), facing),
                    getVSBD(getSBP(-3, 0, 13, 0, 15, 16), facing),
                    getVSBD(getSBP(14, 0, 13, 20, 16, 16), facing),
                    getVSBD(getSBP(9, 2, 15, 10, 16, 16), facing),
                    getVSBD(getSBP(4, 2, 15, 5, 16, 16), facing),
                    getVSBD(getSBP(9, 2, 0, 10, 16, 1), facing),
                    getVSBD(getSBP(-4, 16, 0, 20, 18, 2), facing),
                    getVSBD(getSBP(0, 16, 13, 20, 18, 16), facing),
                    getVSBD(getSBP(5, 1, 0, 14, 2, 1), facing),
                    getVSBD(getSBP(0, 1, 15, 14, 2, 16), facing),
                    getVSBD(getSBP(9, 2, 1, 10, 13, 7), facing),
                    getVSBD(getSBP(9, 2, 9, 10, 13, 15), facing)
            );
        return VoxelShapes.union(
                getVSBD(getSBP(-4, 0, 0, 5, 16, 1), facing),
                getVSBD(getSBP(14, 0, 0, 20, 16, 1), facing),
                getVSBD(getSBP(-3, 0, 13, 0, 15, 16), facing),
                getVSBD(getSBP(14, 0, 13, 20, 16, 16), facing),
                getVSBD(getSBP(9, 2, 15, 10, 16, 16), facing),
                getVSBD(getSBP(4, 2, 15, 5, 16, 16), facing),
                getVSBD(getSBP(9, 2, 0, 10, 16, 1), facing),
                getVSBD(getSBP(-4, 16, 0, 20, 18, 2), facing),
                getVSBD(getSBP(0, 16, 13, 20, 18, 16), facing),
                getVSBD(getSBP(5, 1, 0, 14, 2, 1), facing),
                getVSBD(getSBP(0, 1, 15, 14, 2, 16), facing),
                getVSBD(getSBP(4, 2, 1, 10, 13, 2), facing),
                getVSBD(getSBP(4, 2, 14, 10, 13, 15), facing)
        );
    }

    @Nullable
    protected VoxelShape OutlineShape(BlockState state) {
        Direction facing = state.get(FACING);
        boolean isOpen = state.get(OPEN);
        if(!isOpen)
            return VoxelShapes.union(
                    getVSBD(getSBP(0, -3, -3, 24, 20,20), facing)
            );
    }

    boolean isExit = false;
    public TicketBarrier(Settings settings, boolean isExit) {
        super(settings);
        this.isExit = isExit;
        setDefaultState(getDefaultState().with(FACING, Direction.NORTH));
        setDefaultState(getDefaultState().with(OPEN, false));
        //setDefaultState(getDefaultState().with(EXIT, isExit));
    }

    public static ScoreboardPlayerScore GetScore(World world, PlayerEntity player) {
        return world.getScoreboard().getPlayerScore(player.getName().toString(), world.getScoreboard().getObjective("Entrance"));
    }
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        String Name = state.getBlock().getName().toString();
        boolean contain = false;
        for (var v: player.getHandItems()) {
            if(v.getItem() == TItems.Oyster)
                contain = true;
        }
        if(contain) {
            boolean Pass = TicketSystem.Pass(world, isExit ? 1 : 0 , player);
            if(Pass) {
                world.setBlockState(pos, state.with(OPEN, true));
                world.scheduleBlockTick(pos, state.getBlock(), 40);
                world.setBlockState(pos, state.with(OPEN, false));
            }

            else
                world.setBlockState(pos, state.with(OPEN, false));
        }
        return ActionResult.SUCCESS;
    }


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return initShape(state);
    }
    public boolean isOpen(BlockState state) {
        return state.get(OPEN);
    }

    public Box getSBP(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        // ** getShapeByPixels **
        minX /= 16.0;
        minY /= 16.0;
        minZ /= 16.0;
        maxX /= 16.0;
        maxY /= 16.0;
        maxZ /= 16.0;
        Box box = new Box(minX, minY, minZ, maxX, maxY, maxZ);
        return box;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return initShape(state);
    }

    static VoxelShape getVSBD(@NotNull Box boxin, @NotNull Direction facing) {
        double x1 = boxin.minX;
        double y1 = boxin.minY;
        double z1 = boxin.minZ;
        double x2 = boxin.maxX;
        double y2 = boxin.maxY;
        double z2 = boxin.maxZ;
        //getVoxelShapeByDirection
        Box box;
        switch (facing) {
            case NORTH:
                box = new Box(x1, y1, z1, x2, y2, z2);
            case EAST:
                box = new Box(16 - z2, y1, x1, 16 - z1, y2, x2);
            case SOUTH:
                box = new Box(16 - x2, y1, 16 - z2, 16 - x1, y2, 16 - z1);
            case WEST:
                box = new Box(z1, y1, 16 - x2, z2, y2, 16 - x1);
            default:
                box = new Box(x1, y1, z1, x2, y2, z2);
        }
        return VoxelShapes.cuboid(box);
    }
    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        //Tick tick = new Tick(this, pos,0, TickPriority.HIGH);
        if(isOpen(state))
            //tick.createOrderedTick(2000, 5);
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
