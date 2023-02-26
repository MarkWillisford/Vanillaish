package net.unclesgames.vanillaish.block.custom;

import java.util.Iterator;
import net.minecraft.block.*;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.tag.FluidTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
//import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.*;
import net.minecraft.block.enums.SlabType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.unclesgames.vanillaish.block.ModBlocks;

import java.util.Random;

public class FarmlandSlabBlock extends ToFarmlandSlabBlock {
  public static final    EnumProperty<SlabType> TYPE = Properties.SLAB_TYPE;
  public static final    BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
  public static final    IntProperty MOISTURE = Properties.MOISTURE;
  protected static final VoxelShape TOP_SHAPE = Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 15.0D, 16.0D);
  protected static final VoxelShape BOTTOM_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D);
  protected static final VoxelShape DOUBLE_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 15.0D, 16.0D);

  public FarmlandSlabBlock(Settings settings) {
    super(settings);
    this.setDefaultState(this.stateManager.getDefaultState().with(MOISTURE, 0).with(WATERLOGGED, Boolean.FALSE));
  }

  @Override
  public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
    if (direction == Direction.UP && !state.canPlaceAt(world, pos)) {
      world.createAndScheduleBlockTick(pos, this, 1);
    }

    return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
  }

  @Override
  public boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
    BlockState blockState = world.getBlockState(pos.up());
    return !blockState.getMaterial().isSolid() || blockState.getBlock() instanceof FenceGateBlock || blockState.getBlock() instanceof PistonExtensionBlock;
  }

  @Override
  public boolean hasSidedTransparency(BlockState state) {
    return true;
  }

  @Override
  public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
    if (!state.canPlaceAt(world, pos)) {
      setToDirt(state, world, pos);
    }
  }

  @Override
  public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
    int i = state.get(MOISTURE);
    if (!isWaterNearby(world, pos) && !world.hasRain(pos.up())) {
      if (i > 0) {
        world.setBlockState(pos, state.with(MOISTURE, i - 1), 2);
      }
      else if (!hasCrop(world, pos)) {
        setToDirt(state, world, pos);
      }
    }
    else if (i < 7) {
      world.setBlockState(pos, state.with(MOISTURE, 7), 2);
    }

  }

  @Override
  public void onLandedUpon(World world, BlockState state, BlockPos pos, Entity entity, float distance) {
    if (!world.isClient && world.random.nextFloat() < distance - 0.5F && entity instanceof LivingEntity && (entity instanceof PlayerEntity || world.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) && entity.getWidth() * entity.getWidth() * entity.getHeight() > 0.512F) {
      setToDirt(state, world, pos);
    }

    super.onLandedUpon(world, state, pos, entity, distance);
  }


  public static void setToDirt(BlockState state, World world, BlockPos pos) {
    world.setBlockState(pos, pushEntitiesUpBeforeBlockChange(state, ModBlocks.modBlocks.get("DIRT_SLAB").getStateWithProperties(state), world, pos));
  }

  private static boolean hasCrop(BlockView world, BlockPos pos) {
    Block block = world.getBlockState(pos.up()).getBlock();

    return block instanceof CropBlock || block instanceof StemBlock || block instanceof AttachedStemBlock;
  }

  private static boolean isWaterNearby(WorldView world, BlockPos pos) {
    if (world.getBlockState(pos).get(WATERLOGGED)) return true;

    Iterator var2 = BlockPos.iterate(pos.add(-4, 0, -4), pos.add(4, 1, 4)).iterator();

    BlockPos blockPos;
    do {
      if (!var2.hasNext()) return false;

      blockPos = (BlockPos) var2.next();
    } while (!world.getFluidState(blockPos).getFluid().isIn(FluidTags.WATER));

    return true;
  }

  @Override
  public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
    SlabType slabType = state.get(TYPE);

    switch (slabType) {
      case DOUBLE:
        return DOUBLE_SHAPE;
      case TOP:
        return TOP_SHAPE;
      default:
        return BOTTOM_SHAPE;
    }
  }

  @Override
  protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
    builder.add(TYPE, WATERLOGGED, MOISTURE);
  }
}
