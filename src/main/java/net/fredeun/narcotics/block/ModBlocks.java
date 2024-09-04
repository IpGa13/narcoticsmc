package net.fredeun.narcotics.block;

import net.fredeun.narcotics.NarcoticsMC;
import net.fredeun.narcotics.block.custom.Cocaine;
import net.fredeun.narcotics.block.custom.CocaineWithCash;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.fredeun.narcotics.NarcoticsMC.MOD_ID;

public class ModBlocks {

    //public static final Block CAUCUSCATCHER = registerBlock("caucuscatcherhurensohn", new Block(AbstractBlock.Settings.create()),true);

    public static final Block COCAINE = registerBlock("cocaine", new Cocaine(AbstractBlock.Settings.create().nonOpaque().noCollision()),false);
    public static final Block COCAINE_WITH_CASH = registerBlock("cocaine_with_cash", new CocaineWithCash(AbstractBlock.Settings.create().nonOpaque().noCollision()),false);

    public static final Block SULFUR_ORE = registerBlock("sulfur_ore",new Block(AbstractBlock.Settings.create()),true);
    public static final Block DEEPSLATE_SULFUR_ORE = registerBlock("deepslate_sulfur_ore",new Block(AbstractBlock.Settings.create()),true);
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
