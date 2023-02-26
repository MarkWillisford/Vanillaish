package net.unclesgames.vanillaish.block;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.unclesgames.vanillaish.Vanillaish;
import net.unclesgames.vanillaish.block.custom.*;

public class ModBlocks {
  public static HashMap<String, Block> modBlocks = new HashMap<String, Block>();
//  public static Block GRASS_BLOCK_SLAB;
  private static final String[] colors = new String[] {
    "WHITE", "ORANGE", "MAGENTA", "LIGHT_BLUE", "YELLOW", "LIME", "PINK", "GRAY",
    "LIGHT_GRAY", "CYAN", "PURPLE", "BLUE", "BROWN", "GREEN", "RED", "BLACK"
  };
  private static String[] gravityBlocks = new String[] { "GRAVEL", "SAND", "RED_SAND" };

  // These are the one-offs that don't fit in the main loops
  private static BlockToRegister[] blocksToRegister = new BlockToRegister[] {
    new BlockToRegister("CRACKED_STONE_BRICKS", 1.5F, 6F, Material.STONE, new String[] {"stairs", "slab", "wall", "pressure_plate"}),
    new BlockToRegister("CRACKED_POLISHED_BLACKSTONE_BRICKS", 1.5F, 6F, Material.STONE, new String[] {"stairs", "slab", "wall"}),
    new BlockToRegister("TUFF", 1.5F, 6F, Material.STONE, new String[] {"stairs", "slab", "wall", "pressure_plate", "button"}),
    new BlockToRegister("CRACKED_DEEPSLATE_BRICKS", 3F, 6F, Material.STONE, new String[] {"stairs", "slab", "wall"}),
    new BlockToRegister("CRACKED_DEEPSLATE_TILES", 3F, 6F, Material.STONE, new String[] {"stairs", "slab", "wall"}),
    new BlockToRegister("QUARTZ_BRICKS", .8F, .8F, Material.STONE, new String[] {"stairs", "slab", "wall", "pressure_plate", "button"}),
    new BlockToRegister("CHISELED_QUARTZ_BLOCK", .8F, .8F, Material.STONE, new String[] {"stairs", "slab", "wall", "pressure_plate", "button"}),
    new BlockToRegister("CUT_RED_SANDSTONE", .8F, .8F, Material.STONE, new String[] {"stairs", "wall"}),
    new BlockToRegister("CUT_SANDSTONE", .8F, .8F, Material.STONE, new String[] {"stairs", "wall"}),
    new BlockToRegister("SMOOTH_STONE", 2F, 6F, Material.STONE, new String[] {"stairs", "wall"}),
    new BlockToRegister("CRACKED_NETHER_BRICKS", 2F, 6F, Material.STONE,
      new String[] {"stairs", "slab", "button", "pressure_plate", "fence", "fence_gate", "wall"}),
    new BlockToRegister("NETHER_BRICKS", 2F, 6F, Material.STONE, new String[] {"button", "pressure_plate", "fence_gate"}),
    new BlockToRegister("END_STONE", 3F, 9F, Material.STONE, new String[] {"stairs", "slab", "wall"}),
    new BlockToRegister("CALCITE", 0.75F, 0.75F, Material.STONE, new String[] {"stairs", "slab", "wall", "pressure_plate", "button"}),
    new BlockToRegister("DRIPSTONE_BLOCK", 1.5F, 1F, Material.STONE, new String[] {"stairs", "slab", "wall", "pressure_plate", "button"}),
    new BlockToRegister("TERRACOTTA", 1.25F, 4.2F, Material.STONE, new String[] {"stairs", "slab", "wall"}),
    new BlockToRegister("SMOOTH_BASALT", 1.25F, 4.2F, Material.STONE, new String[] {"stairs", "slab", "wall", "pressure_plate", "button"}),

    new BlockToRegister("CHISELED_STONE_BRICKS", 1.5F, 6F, Material.STONE, new String[] {"stairs", "slab", "wall"}),
    new BlockToRegister("CHISELED_POLISHED_BLACKSTONE", 1.5F, 6F, Material.STONE, new String[] {"stairs", "slab", "wall"}),
    new BlockToRegister("CHISELED_DEEPSLATE", 3F, 6F, Material.STONE, new String[] {"stairs", "slab", "wall"}),
    new BlockToRegister("CHISELED_NETHER_BRICKS", 2F, 6F, Material.STONE, new String[] {"stairs", "slab", "wall"}),
    new BlockToRegister("CHISELED_SANDSTONE", 0.8F, 0.8F, Material.STONE, new String[] {"stairs", "slab", "wall"}),
    new BlockToRegister("CHISELED_RED_SANDSTONE", 0.8F, 0.8F, Material.STONE, new String[] {"stairs", "slab", "wall"}),

    new BlockToRegister("POLISHED_DIORITE", 1.5F, 6F, Material.STONE, new String[] {"wall", "pressure_plate", "button"}),
    new BlockToRegister("POLISHED_GRANITE", 1.5F, 6F, Material.STONE, new String[] {"wall", "pressure_plate", "button"}),
    new BlockToRegister("POLISHED_ANDESITE", 1.5F, 6F, Material.STONE, new String[] {"wall", "pressure_plate", "button"}),
    new BlockToRegister("POLISHED_ANDESITE_BRICKS", 1.5F, 6F, Material.STONE, new String[] {"stairs", "slab", "wall", "pressure_plate"}),
    new BlockToRegister("POLISHED_GRANITE_BRICKS", 1.5F, 6F, Material.STONE, new String[] {"stairs", "slab", "wall", "pressure_plate"}),
    new BlockToRegister("POLISHED_DIORITE_BRICKS", 1.5F, 6F, Material.STONE, new String[] {"stairs", "slab", "wall", "pressure_plate"}),
    new BlockToRegister("CRACKED_POLISHED_ANDESITE_BRICKS", 1.5F, 6F, Material.STONE, new String[] {"stairs", "slab", "wall", "pressure_plate"}),
    new BlockToRegister("CRACKED_POLISHED_GRANITE_BRICKS", 1.5F, 6F, Material.STONE, new String[] {"stairs", "slab", "wall", "pressure_plate"}),
    new BlockToRegister("CRACKED_POLISHED_DIORITE_BRICKS", 1.5F, 6F, Material.STONE, new String[] {"stairs", "slab", "wall", "pressure_plate"}),
    new BlockToRegister("STONE", 1.5F, 6F, Material.STONE, new String[] {"wall"}),
    new BlockToRegister("SMOOTH_SANDSTONE", 2F, 6F, Material.STONE, new String[] {"wall"}),
    new BlockToRegister("SMOOTH_RED_SANDSTONE", 2F, 6F, Material.STONE, new String[] {"wall"}),
    new BlockToRegister("PRISMARINE_BRICKS", 1.5F, 6F, Material.STONE, new String[] {"wall", "pressure_plate", "button"}),
    new BlockToRegister("DARK_PRISMARINE", 1.5F, 6F, Material.STONE, new String[] {"wall", "pressure_plate", "button"}),
    new BlockToRegister("PRISMARINE", 1.5F, 6F, Material.STONE, new String[] {"pressure_plate", "button"}),
    new BlockToRegister("PURPUR_BLOCK", 1.5F, 6F, Material.STONE, new String[] {"wall", "pressure_plate", "button"}),
    new BlockToRegister("QUARTZ_BLOCK", 0.8F, 0.8F, Material.STONE, new String[] {"wall", "pressure_plate", "button"}),
    new BlockToRegister("SMOOTH_QUARTZ", 2F, 6F, Material.STONE, new String[] {"wall", "pressure_plate", "button"}),
    new BlockToRegister("DIORITE", 1.5F, 6F, Material.STONE, new String[] {"pressure_plate", "button"}),
    new BlockToRegister("GRANITE", 1.5F, 6F, Material.STONE, new String[] {"pressure_plate", "button"}),
    new BlockToRegister("ANDESITE", 1.5F, 6F, Material.STONE, new String[] {"pressure_plate", "button"}),
    new BlockToRegister("MOSSY_COBBLESTONE", 1.5F, 6F, Material.STONE, new String[] {"pressure_plate", "button"}),
    new BlockToRegister("MOSSY_STONE_BRICKS", 1.5F, 6F, Material.STONE, new String[] {"pressure_plate"}),
    new BlockToRegister("STONE_BRICKS", 1.5F, 6F, Material.STONE, new String[] {"pressure_plate"}),
    new BlockToRegister("COBBLESTONE", 1.5F, 6F, Material.STONE, new String[] {"pressure_plate", "button"}),
    new BlockToRegister("COBBLED_DEEPSLATE", 3F, 6F, Material.STONE, new String[] {"pressure_plate", "button"}),
    new BlockToRegister("POLISHED_DEEPSLATE", 3F, 6F, Material.STONE, new String[] {"pressure_plate", "button"}),
    new BlockToRegister("BRICKS", 2F, 6F, Material.STONE, new String[] {"pressure_plate", "button"}),
    new BlockToRegister("RED_NETHER_BRICKS", 2F, 6F, Material.STONE, new String[] {"pressure_plate", "button", "fence", "fence_gate"}),//    new BlockToRegister(, 3F, 6F, Material.STONE, new String[]{"wall", "pressure_plate"}),
    new BlockToRegister("OAK_PLANKS", 2F, 6F, Material.WOOD, new String[] {"wall"}),
    new BlockToRegister("SPRUCE_PLANKS", 2F, 6F, Material.WOOD, new String[] {"wall"}),
    new BlockToRegister("BIRCH_PLANKS", 2F, 6F, Material.WOOD, new String[] {"wall"}),
    new BlockToRegister("DARK_OAK_PLANKS", 2F, 6F, Material.WOOD, new String[] {"wall"}),
    new BlockToRegister("JUNGLE_PLANKS", 2F, 6F, Material.WOOD, new String[] {"wall"}),
    new BlockToRegister("ACACIA_PLANKS", 2F, 6F, Material.WOOD, new String[] {"wall"}),
    new BlockToRegister("CRIMSON_PLANKS", 2F, 6F, Material.WOOD, new String[] {"wall"}),
    new BlockToRegister("WARPED_PLANKS", 2F, 6F, Material.WOOD, new String[] {"wall"}),
    new BlockToRegister("OAK_WOOD", 2F, 2F, Material.WOOD, new String[] {"wall"}),
    new BlockToRegister("DARK_OAK_WOOD", 2F, 2F, Material.WOOD, new String[] {"wall"}),
    new BlockToRegister("SPRUCE_WOOD", 2F, 2F, Material.WOOD, new String[] {"wall"}),
    new BlockToRegister("BIRCH_WOOD", 2F, 2F, Material.WOOD, new String[] {"wall"}),
    new BlockToRegister("ACACIA_WOOD", 2F, 2F, Material.WOOD, new String[] {"wall"}),
    new BlockToRegister("JUNGLE_WOOD", 2F, 2F, Material.WOOD, new String[] {"wall"}),
    new BlockToRegister("CRIMSON_HYPHAE", 2F, 2F, Material.NETHER_WOOD, new String[] {"wall"}),
    new BlockToRegister("WARPED_HYPHAE", 2F, 2F, Material.NETHER_WOOD, new String[] {"wall"}),

//    new BlockToRegister(, 3F, 6F, Material.STONE, new String[]{"wall", "pressure_plate"}),
//    new BlockToRegister(, 3F, 6F, Material.STONE, new String[]{"wall", "pressure_plate"}),
//    new BlockToRegister(, 3F, 6F, Material.STONE, new String[]{"wall", "pressure_plate"}),
//    new BlockToRegister("", 3F, 6F, Material.STONE, new String[]{"wall", "pressure_plate"}),
//    new BlockToRegister("", 3F, 6F, Material.STONE, new String[]{"wall", "pressure_plate"}),
//    new BlockToRegister("", 3F, 6F, Material.STONE, new String[]{"wall", "pressure_plate"}),
//    new BlockToRegister("", 3F, 6F, Material.STONE, new String[]{"wall", "pressure_plate"}),
//    new BlockToRegister(, 3F, 6F, Material.STONE, new String[]{"wall", "pressure_plate"})


  };

//  private static BlockToRegister[] transparentBlocksToRegister = new BlockToRegister[] {
//    new BlockToRegister("OAK_LEAVES", .2F, .2F, Material.LEAVES, new String[] {"carpet", "wall"})
//  };

  // Oxidizing blocks
  private static String[] oxidizingBlocksLvl1 = new String[]{
    "COPPER_BLOCK", "CUT_COPPER", "EXPOSED_COPPER", "EXPOSED_CUT_COPPER", "WEATHERED_COPPER", "WEATHERED_CUT_COPPER", "OXIDIZED_COPPER", "OXIDIZED_CUT_COPPER"
  };

  private static Block registerBlock(String name, Block block, ItemGroup group) {
    registerBlockItem(name, block, group);
    return Registry.register(Registry.BLOCK, new Identifier(Vanillaish.MOD_ID, name), block);
  }

  private static Item registerBlockItem(String name, Block block, ItemGroup group) {
    return Registry.register(Registry.ITEM, new Identifier(Vanillaish.MOD_ID, name),
      new BlockItem(block, new FabricItemSettings().group(group)));
  }

  public static void registerModBlocks() throws NoSuchFieldException, IllegalAccessException,
    NoSuchMethodException, InvocationTargetException {
    // Dirt Slabs
    // grass and dirt get hoed into farmland
    modBlocks.put("DIRT_SLAB", registerBlock("dirt_slab",
      new ToFarmlandSlabBlock(FabricBlockSettings.copy(Blocks.DIRT)), ItemGroup.MISC ));;
    modBlocks.put("GRASS_BLOCK_SLAB", registerBlock("grass_block_slab",
      new ToFarmlandSlabBlock(FabricBlockSettings.copy(Blocks.GRASS_BLOCK)), ItemGroup.MISC ));
    // rooted dirt and coarse dirt are hoed into dirt while rooted dirt drops hanging roots
    modBlocks.put("PODZOL_SLAB", registerBlock("podzol_slab",
      new ToDirtPathSlabBlock(FabricBlockSettings.copy(Blocks.PODZOL)), ItemGroup.MISC ));
    modBlocks.put("MYCELIUM_SLAB", registerBlock("mycelium_slab",
      new ToDirtPathSlabBlock(FabricBlockSettings.copy(Blocks.MYCELIUM)), ItemGroup.MISC ));
    modBlocks.put("COARSE_DIRT_SLAB", registerBlock("coarse_dirt_slab",
      new ToDirtPathSlabBlock(FabricBlockSettings.copy(Blocks.COARSE_DIRT)), ItemGroup.MISC ));
    modBlocks.put("ROOTED_DIRT_SLAB", registerBlock("rooted_dirt_slab",
      new ToDirtPathSlabBlock(FabricBlockSettings.copy(Blocks.ROOTED_DIRT)), ItemGroup.MISC ));

    modBlocks.put("FARMLAND_SLAB", registerBlock("farmland_slab",
      new FarmlandSlabBlock(FabricBlockSettings.copy(Blocks.FARMLAND)), ItemGroup.MISC ));
    modBlocks.put("DIRT_PATH_SLAB", registerBlock("DIRT_PATH_SLAB".toLowerCase(),
      new DirtPathSlabBlock(FabricBlockSettings.of(Material.SOIL).strength(.5f).requiresTool()), ItemGroup.MISC ));

    // Dirt Stairs
    modBlocks.put("DIRT_STAIRS", registerBlock("dirt_stairs",
      new ModStairsBlock(Registry.BLOCK.get(new Identifier("dirt_stairs")).getDefaultState(),
        FabricBlockSettings.copy(Blocks.DIRT)), ItemGroup.MISC ));


    String[] dirtBlocks = new String[] { "COARSE_DIRT", "ROOTED_DIRT" };
    for(String newDirt: dirtBlocks) {
      String name = newDirt + "_STAIRS";
      modBlocks.put(name, registerBlock(name.toLowerCase(),
        new ModStairsBlock(Registry.BLOCK.get(new Identifier(newDirt.toLowerCase())).getDefaultState(),
          FabricBlockSettings.of(Material.SOIL).strength(.5f).requiresTool()), ItemGroup.MISC ));
    }
    modBlocks.put("MOSS_BLOCK_STAIRS", registerBlock("moss_block_stairs",
      new ModStairsBlock(Registry.BLOCK.get(new Identifier("moss_block")).getDefaultState(),
        FabricBlockSettings.of(Material.MOSS_BLOCK).strength(.1f).requiresTool()), ItemGroup.MISC));
    modBlocks.put("MOSS_BLOCK_SLAB", registerBlock("moss_block_slab",
      new SlabBlock(FabricBlockSettings.of(Material.MOSS_BLOCK).strength(.1f).requiresTool()), ItemGroup.MISC ));

    // Stone type blocks
    modBlocks.put("POLISHED_ANDESITE_BRICKS", registerBlock("polished_andesite_bricks",
      new Block(FabricBlockSettings.of(Material.STONE).hardness(1.5f).resistance(6.0f).requiresTool()), ItemGroup.MISC ));
    modBlocks.put("POLISHED_GRANITE_BRICKS", registerBlock("polished_granite_bricks",
      new Block(FabricBlockSettings.of(Material.STONE).hardness(1.5f).resistance(6.0f).requiresTool()), ItemGroup.MISC ));
    modBlocks.put("POLISHED_DIORITE_BRICKS", registerBlock("polished_diorite_bricks",
      new Block(FabricBlockSettings.of(Material.STONE).hardness(1.5f).resistance(6.0f).requiresTool()), ItemGroup.MISC ));
    modBlocks.put("CRACKED_POLISHED_ANDESITE_BRICKS", registerBlock("cracked_polished_andesite_bricks",
      new Block(FabricBlockSettings.of(Material.STONE).hardness(1.5f).resistance(6.0f).requiresTool()), ItemGroup.MISC ));
    modBlocks.put("CRACKED_POLISHED_GRANITE_BRICKS", registerBlock("cracked_polished_granite_bricks",
      new Block(FabricBlockSettings.of(Material.STONE).hardness(1.5f).resistance(6.0f).requiresTool()), ItemGroup.MISC ));
    modBlocks.put("CRACKED_POLISHED_DIORITE_BRICKS", registerBlock("cracked_polished_diorite_bricks",
      new Block(FabricBlockSettings.of(Material.STONE).hardness(1.5f).resistance(6.0f).requiresTool()), ItemGroup.MISC ));

    // Glass Blocks
    modBlocks.put("GLASS_STAIRS", registerBlock("glass_stairs",
      new ModStairsBlock(Registry.BLOCK.get(new Identifier("glass")).getDefaultState(),
        FabricBlockSettings.of(Material.GLASS).strength(.3f).requiresTool().nonOpaque()), ItemGroup.MISC));
    modBlocks.put("GLASS_SLAB", registerBlock("glass_slab",
      new SlabBlock(FabricBlockSettings.of(Material.GLASS).strength(.3f).requiresTool().nonOpaque()), ItemGroup.MISC ));
    modBlocks.put("GLASS_WALL", registerBlock("glass_wall",
      new WallBlock(FabricBlockSettings.of(Material.GLASS).strength(0.3f).requiresTool().nonOpaque()), ItemGroup.MISC ));
    modBlocks.put("FRAMED_GLASS", registerBlock("framed_glass",
      new Block(FabricBlockSettings.of(Material.GLASS).strength(0.3f).requiresTool().nonOpaque()), ItemGroup.MISC ));
    modBlocks.put("FRAMED_GLASS_STAIRS", registerBlock("framed_glass_stairs",
      new ModStairsBlock(Registry.BLOCK.get(new Identifier("glass")).getDefaultState(),
        FabricBlockSettings.of(Material.GLASS).strength(.3f).requiresTool().nonOpaque()), ItemGroup.MISC));
    modBlocks.put("FRAMED_GLASS_SLAB", registerBlock("framed_glass_slab",
      new SlabBlock(FabricBlockSettings.of(Material.GLASS).strength(.3f).requiresTool().nonOpaque()), ItemGroup.MISC ));
    modBlocks.put("FRAMED_GLASS_WALL", registerBlock("framed_glass_wall",
      new WallBlock(FabricBlockSettings.of(Material.GLASS).strength(0.3f).requiresTool().nonOpaque()), ItemGroup.MISC ));

    for(String newDirt: gravityBlocks) {
      String name = newDirt + "_SLAB";
      modBlocks.put(name, registerBlock(name.toLowerCase(),
        new ModGravitySlab(FabricBlockSettings.of(Material.SOIL).strength(.5f).requiresTool()), ItemGroup.MISC ));
    }
    for(String newBlock: oxidizingBlocksLvl1) {
      String name = newBlock + "_Wall";
      modBlocks.put(name, registerBlock(name.toLowerCase(),
        new ModOxidizableWall(Oxidizable.OxidationLevel.UNAFFECTED,
          FabricBlockSettings.of(Material.STONE).strength(3f, 6F).requiresTool()),ItemGroup.MISC ));
      name = newBlock + "_PRESSURE_PLATE";
      modBlocks.put(name, registerBlock(name.toLowerCase(),
        new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
          FabricBlockSettings.of(Material.STONE).strength(3F, 6F).requiresTool()), ItemGroup.MISC ));
    }

    // looping through the colors to create concrete, terracotta, and wool; stairs and slabs.
    for (String color: colors) {
      String blockName = color + "_CONCRETE";
      String name = blockName + "_STAIRS";
      modBlocks.put(name, registerBlock(name.toLowerCase(),
        new ModStairsBlock(Registry.BLOCK.get(new Identifier(blockName.toLowerCase())).getDefaultState(),
          FabricBlockSettings.of(Material.STONE).strength(1.8f).requiresTool()), ItemGroup.MISC ));
      name = blockName + "_SLAB";
      modBlocks.put(name, registerBlock(name.toLowerCase(),
        new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).requiresTool()), ItemGroup.MISC ));
      name = blockName + "_WALL";
      modBlocks.put(name, registerBlock(name.toLowerCase(),
        new WallBlock(FabricBlockSettings.of(Material.STONE).strength(1.8f).requiresTool()), ItemGroup.MISC ));

      blockName = color + "_CONCRETE_POWDER";
      name = blockName + "_STAIRS";
      modBlocks.put(name, registerBlock(name.toLowerCase(),
        new ModStairsBlock(Registry.BLOCK.get(new Identifier(blockName.toLowerCase())).getDefaultState(),
          FabricBlockSettings.of(Material.STONE).strength(0.5F).requiresTool()), ItemGroup.MISC ));
      name = blockName + "_SLAB";
      modBlocks.put(name, registerBlock(name.toLowerCase(),
        new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(0.5F).requiresTool()), ItemGroup.MISC ));

      blockName = color + "_TERRACOTTA";
      name = blockName + "_STAIRS";
      modBlocks.put(name, registerBlock(name.toLowerCase(),
        new ModStairsBlock(Registry.BLOCK.get(new Identifier(blockName.toLowerCase())).getDefaultState(),
          FabricBlockSettings.of(Material.STONE).strength(1.25F, 4.2F).requiresTool()), ItemGroup.MISC ));
      name = blockName + "_SLAB";
      modBlocks.put(name, registerBlock(name.toLowerCase(),
        new SlabBlock(FabricBlockSettings.of(Material.STONE).strength(1.25F, 4.2F).requiresTool()), ItemGroup.MISC ));
      name = blockName + "_WALL";
      modBlocks.put(name, registerBlock(name.toLowerCase(),
        new WallBlock(FabricBlockSettings.of(Material.STONE).strength(1.25F, 4.2F).requiresTool()), ItemGroup.MISC ));

      blockName = color + "_WOOL";
      name = blockName + "_STAIRS";
      modBlocks.put(name, registerBlock(name.toLowerCase(),
        new ModStairsBlock(Registry.BLOCK.get(new Identifier(blockName.toLowerCase())).getDefaultState(),
          FabricBlockSettings.of(Material.WOOL).strength(.8f).requiresTool()), ItemGroup.MISC ));
      name = blockName + "_SLAB";
      modBlocks.put(name, registerBlock(name.toLowerCase(),
        new SlabBlock(FabricBlockSettings.of(Material.WOOL).strength(.8f).requiresTool()), ItemGroup.MISC ));

      blockName = color + "_STAINED_GLASS";
      name = blockName + "_STAIRS";
      modBlocks.put(name, registerBlock(name.toLowerCase(),
        new ModStairsBlock(Registry.BLOCK.get(new Identifier(blockName.toLowerCase())).getDefaultState(),
          FabricBlockSettings.copy(Blocks.GLASS).strength(0.3f).requiresTool().nonOpaque()), ItemGroup.MISC ));
      name = blockName + "_SLAB";
      modBlocks.put(name, registerBlock(name.toLowerCase(),
        new SlabBlock(FabricBlockSettings.copy(Blocks.GLASS).strength(0.3f).requiresTool().nonOpaque()), ItemGroup.MISC ));
      name = blockName + "_WALL";
      modBlocks.put(name, registerBlock(name.toLowerCase(),
        new WallBlock(FabricBlockSettings.of(Material.GLASS).strength(0.3f).requiresTool().nonOpaque()), ItemGroup.MISC ));
    }

    for (BlockToRegister btr: blocksToRegister) {
      for (String shape2: btr.shapes) {
        switch (shape2) {
          case "stairs":
            String name = btr.name + "_STAIRS";
            modBlocks.put(name, registerBlock(name.toLowerCase(),
              new ModStairsBlock(Registry.BLOCK.get(new Identifier(btr.name.toLowerCase())).getDefaultState(),
                FabricBlockSettings.of(btr.material).strength(btr.hardness, btr.resistance).requiresTool()), ItemGroup.MISC ));
            break;
          case "slab":
            name = btr.name + "_SLAB";
            modBlocks.put(name, registerBlock(name.toLowerCase(),
              new SlabBlock(FabricBlockSettings.of(btr.material).strength(btr.hardness, btr.resistance).requiresTool()), ItemGroup.MISC ));
            break;
          case "button":
            name = btr.name + "_BUTTON";
            modBlocks.put(name, registerBlock(name.toLowerCase(),
              new ModStoneButtonBlock(FabricBlockSettings.of(btr.material).strength(btr.hardness, btr.resistance).requiresTool().noCollision()), ItemGroup.MISC ));
            break;
          case "pressure_plate":
            name = btr.name + "_PRESSURE_PLATE";
            modBlocks.put(name, registerBlock(name.toLowerCase(),
              new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
                FabricBlockSettings.of(btr.material).strength(btr.hardness, btr.resistance).requiresTool()), ItemGroup.MISC ));
            break;
          case "fence":
            name = btr.name + "_FENCE";
            modBlocks.put(name, registerBlock(name.toLowerCase(),
              new FenceBlock(FabricBlockSettings.of(btr.material).strength(btr.hardness, btr.resistance).requiresTool()), ItemGroup.MISC ));
            break;
          case "fence_gate":
            name = btr.name + "_FENCE_GATE";
            modBlocks.put(name, registerBlock(name.toLowerCase(),
              new FenceGateBlock(FabricBlockSettings.of(btr.material).strength(btr.hardness, btr.resistance).requiresTool()), ItemGroup.MISC ));
            break;
          case "wall":
            name = btr.name + "_WALL";
            modBlocks.put(name, registerBlock(name.toLowerCase(),
              new WallBlock(FabricBlockSettings.of(btr.material).strength(btr.hardness, btr.resistance).requiresTool()), ItemGroup.MISC ));
            break;
          case "carpet":
            name = btr.name + "_CARPET";
            //  public static final Block MOSS_CARPET = Blocks.register("moss_carpet", new CarpetBlock(AbstractBlock.Settings.of(Material.PLANT, MapColor.GREEN).strength(0.1f).sounds(BlockSoundGroup.MOSS_CARPET)));
            modBlocks.put(name, registerBlock(name.toLowerCase(),
              new CarpetBlock(FabricBlockSettings.of(btr.material).strength(btr.hardness, btr.resistance).requiresTool()), ItemGroup.MISC));
            break;





//          public static final Block CRACKED_NETHER_BRICKS_BUTTON = registerBlock("cracked_nether_bricks_button",
//            new ModStoneButtonBlock(FabricBlockSettings.of(Material.STONE).strength(2F, 6F).requiresTool().noCollision()), ItemGroup.MISC );
//          public static final Block CRACKED_NETHER_BRICKS_PRESSURE_PLATE = registerBlock("cracked_nether_bricks_pressure_plate",
//            new ModPressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING,
//              FabricBlockSettings.of(Material.STONE).strength(2F, 6F).requiresTool()), ItemGroup.MISC );
//          public static final Block CRACKED_NETHER_BRICKS_FENCE = registerBlock("cracked_nether_bricks_fence",
//            new FenceBlock(FabricBlockSettings.of(Material.STONE).strength(2F, 6F).requiresTool()), ItemGroup.MISC );
//          public static final Block CRACKED_NETHER_BRICKS_FENCE_GATE = registerBlock("cracked_nether_bricks_fence_gate",
//            new FenceGateBlock(FabricBlockSettings.of(Material.STONE).strength(2F, 6F).requiresTool()), ItemGroup.MISC );
//          public static final Block CRACKED_NETHER_BRICKS_WALL = registerBlock("cracked_nether_bricks_wall",
//            new WallBlock(FabricBlockSettings.of(Material.STONE).strength(2F, 6F).requiresTool()), ItemGroup.MISC );


        }
      }
    }

    Vanillaish.LOGGER.info("Registering Blocks for " + Vanillaish.MOD_ID);
  }
}
