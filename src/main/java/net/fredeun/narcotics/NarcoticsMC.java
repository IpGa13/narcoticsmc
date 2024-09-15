package net.fredeun.narcotics;

import net.fabricmc.api.ModInitializer;

import net.fredeun.narcotics.block.ModBlocks;
import net.fredeun.narcotics.effect.ModEffects;
import net.fredeun.narcotics.fluid.ModFluids;
import net.fredeun.narcotics.item.ModItems;
import net.fredeun.narcotics.sound.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NarcoticsMC implements ModInitializer {
	public static final String MOD_ID = "narcotics";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		//ModFluids.registerModFluids();
		ModBlocks.registerModBlocks();
		ModSounds.registerModSounds();
		ModEffects.registerModEffects();
		ModItems.registerModItems();
		ModItemGroups.registerModItemGroups();

		//LOGGER.info("Hello Fabric world!");
	}
}