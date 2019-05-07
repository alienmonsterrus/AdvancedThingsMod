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
        for(Biome biome : ForgeRegistries.BIOMES)
        {
            CountRangeConfig azure_ore_placement = new CountRangeConfig(
                300, 2, 30, 50);

            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                new CompositeFeature<>(Feature.MINABLE,
                new MinableConfig(MinableConfig.IS_ROCK, BlockList.AzureOre.getDefaultState(), 20),
                new CountRange(), azure_ore_placement));
        }

        for(Biome biome : ForgeRegistries.BIOMES)
        {
            CountRangeConfig magnetic_ore_placement = new CountRangeConfig(
                    250, 2, 30, 50);

            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                new CompositeFeature<>(Feature.MINABLE,
                new MinableConfig(MinableConfig.IS_ROCK, BlockList.MagneticOre.getDefaultState(), 20),
                new CountRange(), magnetic_ore_placement));
        }
        for(Biome biome : ForgeRegistries.BIOMES)
        {
            CountRangeConfig cool_ore_placement = new CountRangeConfig(
                    100, 2, 11, 16);

            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                new CompositeFeature<>(Feature.MINABLE,
                new MinableConfig(MinableConfig.IS_ROCK, BlockList.CoolOre.getDefaultState(), 20),
                new CountRange(), cool_ore_placement));
        }

    }
}
