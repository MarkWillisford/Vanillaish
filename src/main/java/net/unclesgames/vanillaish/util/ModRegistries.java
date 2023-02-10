package net.unclesgames.vanillaish.util;

import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.color.world.FoliageColors;
import net.minecraft.client.color.world.GrassColors;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.unclesgames.vanillaish.Vanillaish;
import net.unclesgames.vanillaish.block.ModBlocks;

public class ModRegistries {
  public static void registerModStuffs() {
    registerBlockColorProviders();
  }

  private static void registerBlockColorProviders() {
    Vanillaish.LOGGER.info("Registering ColorProviders for " + Vanillaish.MOD_ID);
    ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
      if (tintIndex == 1) {
        return view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : GrassColors.getColor(0.5D, 1.0D);
      }
      return -1;
    }, ModBlocks.modBlocks.get("GRASS_BLOCK_SLAB"), ModBlocks.modBlocks.get("GRASS_BLOCK_STAIRS"));

    ColorProviderRegistry.ITEM.register((stack, tintIndex) -> GrassColors.getColor(0.5D, 1.0D),
      ModBlocks.modBlocks.get("GRASS_BLOCK_SLAB"), ModBlocks.modBlocks.get("GRASS_BLOCK_STAIRS"));


//    ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
//      if (tintIndex == 1) {
//        return view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : GrassColors.getColor(0.5D, 1.0D);
//      }
//      return -1;
//    }, ModBlocks.modBlocks.get("GRASS_BLOCK_SLAB"));
//    ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> {
//      if (tintIndex == 1) {
//        return view != null && pos != null ? BiomeColors.getGrassColor(view, pos) : GrassColors.getColor(0.5D, 1.0D);
//      }
//      return -1;
//    }, ModBlocks.modBlocks.get("GRASS_BLOCK_STAIRS"));
/*
    ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BiomeColors.getGrassColor(view, pos), ModBlocks.modBlocks.get("GRASS_BLOCK_SLAB"), ModBlocks.modBlocks.get("GRASS_BLOCK_SLAB_TOP"));
    ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> view != null && pos != null ? BiomeColors.getFoliageColor(view, pos) : FoliageColors.getDefaultColor(), ModBlocks.modBlocks.get("GRASS_BLOCK_SLAB"));
    ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> 0x3495eb, ModBlocks.modBlocks.get("GRASS_BLOCK_SLAB"));
*/
  }
}
