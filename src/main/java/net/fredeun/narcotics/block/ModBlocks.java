package net.fredeun.narcotics.block;

import net.fredeun.narcotics.NarcoticsMC;
import net.fredeun.narcotics.block.custom.CocaPlant;
import net.fredeun.narcotics.block.custom.Cocaine;
import net.fredeun.narcotics.block.custom.CocaineWithCash;
import net.fredeun.narcotics.fluid.ModFluids;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static net.fredeun.narcotics.NarcoticsMC.MOD_ID;

public class ModBlocks {

    //public static final Block CAUCUSCATCHER = registerBlock("caucuscatcherfourthousand", new Block(AbstractBlock.Settings.create()),true);

    public static final Block COCAINE = registerBlock("cocaine", new Cocaine(AbstractBlock.Settings.create().nonOpaque().noCollision()),false);
    public static final Block COCAINE_WITH_CASH = registerBlock("cocaine_with_cash", new CocaineWithCash(AbstractBlock.Settings.create().nonOpaque().noCollision()),false);
    public static final Block COCA_PLANT = registerBlock("coca_plant", new CocaPlant(AbstractBlock.Settings.create().nonOpaque().ticksRandomly().sounds(BlockSoundGroup.AZALEA_LEAVES)),false);
    public static final Block SULFUR_ORE = registerBlock("sulfur_ore",new Block(AbstractBlock.Settings.create()),true);
    public static final Block DEEPSLATE_SULFUR_ORE = registerBlock("deepslate_sulfur_ore",new Block(AbstractBlock.Settings.create()),true);


    public static final Block SULFURIC_ACID_BLOCK = registerBlock("sulfuric_acid", new FluidBlock(ModFluids.SULFURIC_ACID,AbstractBlock.Settings.copy(Blocks.WATER)),false);
    public static final Block COCA_SOLUTION = registerBlock("coca_solution", new FluidBlock(ModFluids.COCA_SOLUTION,AbstractBlock.Settings.copy(Blocks.WATER)),false);





    public static Block registerBlock(String name, Block block,boolean autoItem) {
        Identifier id = Identifier.of(MOD_ID,name);
        if(autoItem) {
            registerBlockItem(id,block);
        }
        return Registry.register(Registries.BLOCK,id,block);
    }
    public static void registerBlockItem(Identifier id, Block block) {
        Registry.register(Registries.ITEM, id, new BlockItem(block, new Item.Settings()));
    }
    public static void registerModBlocks() {
        NarcoticsMC.LOGGER.info("Registering Blocks for " + MOD_ID);
    }
}
