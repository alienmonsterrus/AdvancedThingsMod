package com.team_autists.advancedthings;

import com.team_autists.advancedthings.blocks.BlockList;
import com.team_autists.advancedthings.items.*;
import com.team_autists.advancedthings.world.OreGeneration;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(References.MOD_ID)
public class AdvancedThings {

	private static AdvancedThings instance;
	private static final Logger LOGGER = LogManager.getLogger();

	public AdvancedThings() {

		instance = this;

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {
		OreGeneration.setupOreGeneration();
		LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
	}

	private void clientRegistries(final FMLClientSetupEvent event) {
		LOGGER.info("Client Registries method called");
	}

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {

		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {

			event.getRegistry().registerAll(
				ItemList.TutorialItem = new Item(new Item.Properties()
					.group(ItemGroup.MISC)).setRegistryName(location("tutorial_item")),

				ItemList.FutureBlock = new ItemBlock(BlockList.FutureBlock, new Item.Properties()
					.group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(BlockList.FutureBlock.getRegistryName()),

				ItemList.CobblestoneBricks = new ItemBlock(BlockList.CobblestoneBricks, new Item.Properties()
					.group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(BlockList.CobblestoneBricks.getRegistryName()),

				ItemList.CoolOre = new ItemBlock(BlockList.CoolOre, new Item.Properties()
					.group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(BlockList.CoolOre.getRegistryName()),

				ItemList.AzureOre = new ItemBlock(BlockList.AzureOre, new Item.Properties()
					.group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(BlockList.AzureOre.getRegistryName()),

				ItemList.MagneticOre = new ItemBlock(BlockList.MagneticOre, new Item.Properties()
					.group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(BlockList.MagneticOre.getRegistryName()),

				ItemList.FutureCore = new Item(new Item.Properties()
					.group(ItemGroup.MISC)).setRegistryName(location("future_core")),

				ItemList.AzureIngot = new Item(new Item.Properties()
					.group(ItemGroup.MISC)).setRegistryName(location("azure_ingot")),

				ItemList.CoolIngot = new Item(new Item.Properties()
					.group(ItemGroup.MISC)).setRegistryName(location("cool_ingot")),

				ItemList.MagneticIngot = new Item(new Item.Properties()
					.group(ItemGroup.MISC)).setRegistryName(location("magnetic_ingot")),

                ItemList.CompositeIngot = new Item(new Item.Properties()
                    .group(ItemGroup.MISC)).setRegistryName(location("composite_ingot")),

                ItemList.CompositeChunk = new Item(new Item.Properties()
                    .group(ItemGroup.MISC)).setRegistryName(location("composite_chunk")),

				ItemList.AdvancedPickaxe = new ItemCustomPickaxe(
					ToolMaterialList.ADVANCED, -4,6.0F, new Item.Properties()
					.group(ItemGroup.TOOLS)).setRegistryName(location("advanced_pickaxe")),

				ItemList.AdvancedSaber = new ItemCustomSaber(
					ToolMaterialList.ADVANCED, 6, 6.0F, new Item.Properties()
					.group(ItemGroup.COMBAT)).setRegistryName(location("advanced_saber")),

				ItemList.AdvancedShovel = new ItemCustomShovel(
					ToolMaterialList.ADVANCED, -10, 6.0F, new Item.Properties()
					.group(ItemGroup.TOOLS)).setRegistryName(location("advanced_shovel")),

                ItemList.MagneticPickaxe = new ItemCustomPickaxe(
                    ToolMaterialList.MAGNETICINGOT, 1,6.0F, new Item.Properties()
                    .group(ItemGroup.TOOLS)).setRegistryName(location("magnetic_pickaxe")),

                ItemList.MagneticSword = new ItemCustomSaber(
                    ToolMaterialList.MAGNETICINGOT, 1, 6.0F, new Item.Properties()
                    .group(ItemGroup.COMBAT)).setRegistryName(location("magnetic_sword")),

                ItemList.MagneticShovel = new ItemCustomShovel(
                    ToolMaterialList.MAGNETICINGOT, -6, 6.0F, new Item.Properties()
                    .group(ItemGroup.TOOLS)).setRegistryName(location("magnetic_shovel")),

                ItemList.CoolPickaxe = new ItemCustomPickaxe(
                    ToolMaterialList.COOLINGOT, 1,6.0F, new Item.Properties()
                    .group(ItemGroup.TOOLS)).setRegistryName(location("cool_pickaxe")),

                ItemList.CoolSword = new ItemCustomSaber(
                    ToolMaterialList.COOLINGOT, 6, 6.0F, new Item.Properties()
                    .group(ItemGroup.COMBAT)).setRegistryName(location("cool_sword")),

                ItemList.CoolShovel = new ItemCustomShovel(
                    ToolMaterialList.COOLINGOT, -6, 6.0F, new Item.Properties()
                    .group(ItemGroup.TOOLS)).setRegistryName(location("cool_shovel")),

                ItemList.AzurePickaxe= new ItemCustomPickaxe(
                    ToolMaterialList.AZUREINGOT, 1,6.0F, new Item.Properties()
                    .group(ItemGroup.TOOLS)).setRegistryName(location("azure_pickaxe")),

                ItemList.AzureSword = new ItemCustomSaber(
                    ToolMaterialList.AZUREINGOT, 6, 6.0F, new Item.Properties()
                    .group(ItemGroup.COMBAT)).setRegistryName(location("azure_sword")),

                ItemList.AzureShovel = new ItemCustomShovel(
                    ToolMaterialList.AZUREINGOT, -6, 6.0F, new Item.Properties()
                    .group(ItemGroup.TOOLS)).setRegistryName(location("azure_shovel"))


			);
		}

		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {

			event.getRegistry().registerAll(
				BlockList.FutureBlock = new Block(Block.Properties.create(Material.ROCK)
					.hardnessAndResistance(2.0f, 3.0f)
					.lightValue(5).sound(SoundType.GLASS))
					.setRegistryName(location("future_block")),

				BlockList.CobblestoneBricks = new Block(Block.Properties.create(Material.ROCK)
					.hardnessAndResistance(2.0f,3.0f)
					.lightValue(5).sound(SoundType.STONE))
					.setRegistryName(location("cobblestone_bricks")),

                BlockList.AzureOre = new Block(Block.Properties.create(Material.ROCK)
					.hardnessAndResistance(2.0f,3.0f)
					.lightValue(5).sound(SoundType.STONE))
					.setRegistryName(location("azure_ore_block")),

                BlockList.CoolOre = new Block(Block.Properties.create(Material.ROCK)
					.hardnessAndResistance(2.0f,3.0f)
					.lightValue(5).sound(SoundType.STONE))
					.setRegistryName(location("cool_ore_block")),

                BlockList.MagneticOre = new Block(Block.Properties.create(Material.ROCK)
					.hardnessAndResistance(2.0f,3.0f)
					.lightValue(5).sound(SoundType.STONE))
					.setRegistryName(location("magnetic_ore_block"))
			);
		}

		private static ResourceLocation location(String name) {
			return new ResourceLocation(References.MOD_ID, name);
		}
	}

	public static AdvancedThings getInstance() {
		return instance;
	}
}
