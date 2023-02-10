package net.unclesgames.vanillaish;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.unclesgames.vanillaish.block.ModBlocks;

public class VanillaishClientMod implements ClientModInitializer {
  private static final String[] colors = new String[] {
    "WHITE", "ORANGE", "MAGENTA", "LIGHT_BLUE", "YELLOW", "LIME", "PINK", "GRAY",
    "LIGHT_GRAY", "CYAN", "PURPLE", "BLUE", "BROWN", "GREEN", "RED", "BLACK"
  };

  @Override
  public void onInitializeClient() {
    for (String color: colors) {
      String blockName = color + "_STAINED_GLASS";
      String name = blockName + "_SLAB";
      BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.modBlocks.get(name), RenderLayer.getTranslucent());
      name = blockName + "_STAIRS";
      BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.modBlocks.get(name), RenderLayer.getTranslucent());
      name = blockName + "_WALL";
      BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.modBlocks.get(name), RenderLayer.getTranslucent());
    }

    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.modBlocks.get("GLASS_STAIRS"), RenderLayer.getTranslucent());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.modBlocks.get("GLASS_SLAB"), RenderLayer.getTranslucent());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.modBlocks.get("GLASS_WALL"), RenderLayer.getTranslucent());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.modBlocks.get("FRAMED_GLASS"), RenderLayer.getTranslucent());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.modBlocks.get("FRAMED_GLASS_STAIRS"), RenderLayer.getTranslucent());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.modBlocks.get("FRAMED_GLASS_SLAB"), RenderLayer.getTranslucent());
    BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.modBlocks.get("FRAMED_GLASS_WALL"), RenderLayer.getTranslucent());
  }
}
