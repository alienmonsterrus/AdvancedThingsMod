package com.team_autists.advancedthings.items;

import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

public enum ToolMaterialList implements IItemTier
{
    ADVANCED(10.0F, 10.0F, 4096, 6, 25, ItemList.FutureCore),
    AZUREINGOT(5.0F, 4.0F, 512, 4, 25, ItemList.AzureIngot),
    MAGNETICINGOT(5.0F, 4.0F, 721, 4, 25, ItemList.MagneticIngot),
    COOLINGOT(7.0F, 7.0F, 1024, 4, 25, ItemList.CoolIngot);

    private float attackDamage, efficiency;
    private int durability, harvestLevel, enchantability;
    private Item repairMaterial;

    ToolMaterialList(float attackDamage, float efficiency, int durability,
		int harvestLevel, int enchantability, Item repairMaterial) {

        this.attackDamage = attackDamage;
        this.efficiency = efficiency;
        this.durability = durability;
        this.enchantability = enchantability;
        this.harvestLevel = harvestLevel;
        this.repairMaterial = repairMaterial;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public float getEfficiency() {
        return this.efficiency;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public int getHarvestLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getMaxUses() {
        return this.durability;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return Ingredient.fromItems(this.repairMaterial);
    }
}
