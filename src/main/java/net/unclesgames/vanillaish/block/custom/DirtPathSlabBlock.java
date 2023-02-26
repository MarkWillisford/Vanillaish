package net.unclesgames.vanillaish.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.enums.SlabType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class DirtPathSlabBlock extends SlabBlock {
  public DirtPathSlabBlock(Settings settings) {
    super(settings);
  }
  protected static final VoxelShape BOTTOM_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 7.0, 16.0);
  protected static final VoxelShape TOP_SHAPE = Block.createCuboidShape(0.0, 8.0, 0.0, 16.0, 15.0, 16.0);

  @Override
  public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
    SlabType slabType = state.get(TYPE);
    switch (slabType) {
      case DOUBLE: {
        return VoxelShapes.fullCube();
      }
      case TOP: {
        return TOP_SHAPE;
      }
    }
    return BOTTOM_SHAPE;
  }
}
