package net.unclesgames.vanillaish.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.unclesgames.vanillaish.Vanillaish;
import net.unclesgames.vanillaish.item.custom.DowsingRodItem;

public class ModItems {
  public static final Item DOWSING_ROD = registerItem("dowsing_rod",
    new DowsingRodItem(new FabricItemSettings().group(ItemGroup.MISC).maxDamage(16)));

  private static Item registerItem(String name, Item item) {
    return Registry.register(Registry.ITEM, new Identifier(Vanillaish.MOD_ID, name), item);
  }

  public static void registerModItems() {
    Vanillaish.LOGGER.info("Registering Mod Items for " + Vanillaish.MOD_ID);
  }
}
