package com.team_autists.advancedthings.world;

import com.team_autists.advancedthings.blocks.BlockList;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.CompositeFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.MinableConfig;
import net.minecraft.world.gen.placement.CountRange;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGeneration
{
    public static void setupOreGeneration()
    {
        for (Biome biome : ForgeRegistries.BIOMES)
        {
            addAzureOre(biome);
            addMagneticOre(biome);
            addCoolOre(biome);
        }
    }

    private static void addAzureOre(Biome biome) {

        CountRangeConfig azure_ore_placement = new CountRangeConfig(
                2, 2, 5, 60);

        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                new CompositeFeature<>(Feature.MINABLE,
                        new MinableConfig(MinableConfig.IS_ROCK, BlockList.AzureOre.getDefaultState(), 20),
                        new CountRange(), azure_ore_placement));
    }

    private static void addMagneticOre(Biome biome) {

        CountRangeConfig magnetic_ore_placement = new CountRangeConfig(
                2, 2, 5, 60);

        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                new CompositeFeature<>(Feature.MINABLE,
                        new MinableConfig(MinableConfig.IS_ROCK, BlockList.MagneticOre.getDefaultState(), 20),
                        new CountRange(), magnetic_ore_placement));
    }

    private static void addCoolOre(Biome biome) {

        CountRangeConfig cool_ore_placement = new CountRangeConfig(
                2, 2, 5, 60);

        biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
            new CompositeFeature<>(Feature.MINABLE,
                new MinableConfig(MinableConfig.IS_ROCK, BlockList.CoolOre.getDefaultState(), 20),
                new CountRange(), cool_ore_placement));
    }
}
