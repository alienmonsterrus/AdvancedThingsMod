package com.team_autists.advancedthings;

import com.team_autists.advancedthings.blocks.BlockList;
import com.team_autists.advancedthings.items.*;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemPickaxe;
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

		LOGGER.info("Hello from AdvancedThings Mod!");

		instance = this;

		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientRegistries);

		MinecraftForge.EVENT_BUS.register(this);
	}

	private void setup(final FMLCommonSetupEvent event) {
		LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
	}

	private void clientRegistries(final FMLClientSetupEvent event) {
		LOGGER.info("Client Registries method called");
	}

	// You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
	// Event bus for receiving Registry Events)
	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistryEvents {

		@SubscribeEvent
		public static void registerItems(final RegistryEvent.Register<Item> event) {
			event.getRegistry().registerAll(
				ItemList.TutorialItem = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("tutorial_item")),
				ItemList.FutureBlock = new ItemBlock(BlockList.FutureBlock, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(BlockList.FutureBlock.getRegistryName()),
				ItemList.CobblestoneBricks = new ItemBlock(BlockList.CobblestoneBricks, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName(BlockList.CobblestoneBricks.getRegistryName()),
				ItemList.FutureCore = new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName(location("future_core")),
				ItemList.AdvancedPickaxe = new ItemCustomPickaxe(ToolMaterialList.advanced, -4,6.0F, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("advanced_pickaxe")),
				ItemList.AdvancedSaber = new ItemCustomSaber(ToolMaterialList.advanced, 6, 6.0F, new Item.Properties().group(ItemGroup.COMBAT)).setRegistryName(location("advanced_saber")),
				ItemList.AdvancedShovel = new ItemCustomShovel(ToolMaterialList.advanced, -6, 6.0F, new Item.Properties().group(ItemGroup.TOOLS)).setRegistryName(location("advanced_shovel"))
			);

			LOGGER.info("Items registered");


		}

		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			event.getRegistry().registerAll(
				BlockList.FutureBlock = new Block(Block.Properties.create(Material.ROCK)
					.hardnessAndResistance(2.0f, 3.0f)
					.lightValue(5).sound(SoundType.GLASS)).setRegistryName(location("future_block")),
				BlockList.CobblestoneBricks = new Block(Block.Properties.create(Material.ROCK)
					.hardnessAndResistance(2.0f,3.0f).lightValue(5).sound(SoundType.STONE))
					.setRegistryName(location("cobblestone_bricks"))
			);

			LOGGER.info("Blocks registered");
		}

		private static ResourceLocation location(String name) {
			return new ResourceLocation(References.MOD_ID, name);
		}
	}

	public static AdvancedThings getInstance() {
		return instance;
	}
}
