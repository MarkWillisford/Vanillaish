package net.unclesgames.vanillaish.block.custom;

import net.minecraft.block.Material;

public class BlockToRegister {
  public String name;
  public String[] shapes;
  public Float hardness;
  public Float resistance;
  public Material material;

  public BlockToRegister(String name, Float hardness, Float resistance, Material material, String[] shapes) {
    this.name = name;
    this.shapes = shapes;
    this.hardness = hardness;
    this.resistance = resistance;
    this.material = material;
  }
}
