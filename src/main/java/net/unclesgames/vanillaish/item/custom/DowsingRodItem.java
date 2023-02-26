package net.unclesgames.vanillaish.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

public class DowsingRodItem extends Item {

  public DowsingRodItem(Settings settings) {
    super(settings);
  }

  @Override
  public ActionResult useOnBlock(ItemUsageContext context) {
    // checks to insure we are on the client thread
    if(context.getWorld().isClient()) {
      BlockPos positionClicked = context.getBlockPos();
      PlayerEntity player = context.getPlayer();
      boolean foundBlock = false;

      for(int i=positionClicked.getY(); i>=(-64); i--) {
        Block blockBelow = context.getWorld().getBlockState(positionClicked.withY(i)).getBlock();
        player.sendMessage(Text.literal("checking " + i + ", found " + blockBelow.asItem().getName().getString()), false);

        if(isValuableBlock(blockBelow)) {
          outputValuableCoordinates(positionClicked.withY(i), player, blockBelow);
          foundBlock = true;
          break;
        }
      }

      if(!foundBlock) {
        player.sendMessage(Text.literal("item.vanillaish.dowsing_rod.no_valuables"), false);
      }
    }

    // How would I make this accept the unbreakable enchantment?
    context.getStack().damage(1, context.getPlayer(),
      (player) -> player.sendToolBreakStatus(player.getActiveHand()));

    return super.useOnBlock(context);
  }

  private void outputValuableCoordinates(BlockPos blockPos, PlayerEntity player, Block blockBelow) {
    player.sendMessage(Text.literal("Found " + blockBelow.asItem().getName().getString() + " at " +
      "(" + blockPos.getX() + ", " + blockPos.getY() + "," + blockPos.getZ() + ")"), false);
  }

  private boolean isValuableBlock(Block block) {
    return block == Blocks.COAL_ORE || block == Blocks.COPPER_ORE
      || block == Blocks.DIAMOND_ORE || block == Blocks.IRON_ORE;
  }
}
