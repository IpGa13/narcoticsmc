package net.fredeun.narcotics.item;

import net.fredeun.narcotics.NarcoticsMC;
import net.fredeun.narcotics.block.ModBlocks;
import net.fredeun.narcotics.fluid.ModFluids;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static net.fredeun.narcotics.NarcoticsMC.MOD_ID;

public class ModItems {
    //
    // DRUG ITEMS
    //
    public static final Item COCAINE_ITEM = registerItem("cocaine", new AliasedBlockItem(ModBlocks.COCAINE,new Item.Settings()));
    public static final Item COCAINE_CASH_ITEM = registerItem("cocaine_with_cash", new AliasedBlockItem(ModBlocks.COCAINE_WITH_CASH,new Item.Settings()));
    public static final Item CASH_ITEM = registerItem("cash", new Item(new Item.Settings()));
    public static final Item COCA_LEAF = registerItem("coca_leaf",new Item(new Item.Settings()));
    public static final Item COCA_SEEDS = registerItem("coca_seeds",new AliasedBlockItem(ModBlocks.COCA_PLANT, new Item.Settings()));

    //
    // DRUG RESOURCES
    //
    public static final Item SULFUR = registerItem("sulfur", new Item(new Item.Settings()));
    public static final Item RAW_SULFUR = registerItem("raw_sulfur", new Item(new Item.Settings()));
    public static final Item AMMONIA = registerItem("ammonia", new Item(new Item.Settings()));
    public static final Item SULFURIC_ACID_BUCKET = registerItem("sulfuric_acid_bucket", new BucketItem(ModFluids.SULFURIC_ACID, new Item.Settings()));
    public static final Item COCA_SOLUTION_BUCKET = registerItem("coca_solution_bucket", new BucketItem(ModFluids.COCA_SOLUTION, new Item.Settings()));


    //METHODS
    public static Item registerItem(String name,Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MOD_ID,name),item);
    }
    public static void registerModItems() {
        NarcoticsMC.LOGGER.info("Registering Items of "+ MOD_ID);
    }
}
