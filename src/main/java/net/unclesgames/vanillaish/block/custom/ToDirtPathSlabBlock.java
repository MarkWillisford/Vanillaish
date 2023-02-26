package net.unclesgames.vanillaish.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.Waterloggable;
import net.minecraft.block.enums.SlabType;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.shape.VoxelShape;

public class ToDirtPathSlabBlock extends SlabBlock implements Waterloggable {
  public static final EnumProperty<SlabType> TYPE = Properties.SLAB_TYPE;
  public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
  static final VoxelShape BOTTOM_SHAPE = Block.createCuboidShape(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);
  static final VoxelShape TOP_SHAPE = Block.createCuboidShape(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D);

  public ToDirtPathSlabBlock(Settings settings) {
    super(settings);
    this.setDefaultState(this.getDefaultState().with(TYPE, SlabType.TOP).with(WATERLOGGED, Boolean.FALSE));
  }
}
