package net.unclesgames.vanillaish.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.HoeItem;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.unclesgames.vanillaish.block.ModBlocks;
import net.unclesgames.vanillaish.block.custom.ToFarmlandSlabBlock;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(HoeItem.class)
public abstract class HoeMixin {
  @Inject(method = "useOnBlock", at = @At("RETURN"))
  protected void injectUseOnBlockMethod(ItemUsageContext context, CallbackInfoReturnable<ActionResult> cbir) {
    World world = context.getWorld();
    BlockPos blockPos = context.getBlockPos();
    BlockState state = world.getBlockState(blockPos);
    Block block = state.getBlock();

    if (block instanceof ToFarmlandSlabBlock) {
      PlayerEntity playerEntity = context.getPlayer();
      world.playSound(playerEntity, blockPos, SoundEvents.ITEM_HOE_TILL, SoundCategory.BLOCKS, 1.0F, 1.0F);
      world.setBlockState(blockPos, ModBlocks.modBlocks.get("FARMLAND_SLAB").getStateWithProperties(state));
      if (!world.isClient) {
        if (playerEntity != null) {
          context.getStack().damage(1, playerEntity, (p) -> {
            p.sendToolBreakStatus(context.getHand());
          });
        }
      }
//      cbir.setReturnValue(ActionResult.success(world.isClient));
    } else {
      cbir.setReturnValue(ActionResult.PASS);
    }
  }
}
