package net.fredeun.narcotics;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fredeun.narcotics.block.ModBlocks;
import net.fredeun.narcotics.item.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.fredeun.narcotics.NarcoticsMC.MOD_ID;

public class ModItemGroups {


    public static final ItemGroup COCAINE_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(MOD_ID,"cocaine_items"),
            FabricItemGroup.builder().icon(() -> ModItems.COCAINE_ITEM.getDefaultStack()).
                    displayName(Text.translatable("itemgroup.nartotics.cocaine"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.COCAINE_ITEM);
                        entries.add(ModItems.CASH_ITEM);
                        entries.add(ModItems.COCAINE_CASH_ITEM);
                    })

                    .build());

    public static final ItemGroup RESOURCES_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP,Identifier.of(MOD_ID,"narcotics_resources"),
            FabricItemGroup.builder().icon(() -> ModItems.SULFUR.getDefaultStack()).
                    displayName(Text.translatable("itemgroup.narcotics.resources"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.SULFUR);
                        entries.add(ModItems.RAW_SULFUR);
                        entries.add(ModBlocks.SULFUR_ORE);
                        entries.add(ModBlocks.DEEPSLATE_SULFUR_ORE);
                        entries.add(ModItems.AMMONIA);
                    })


                    .build());
    public static void registerModItemGroups() {
        NarcoticsMC.LOGGER.info("Registering ItemGroups of "+ MOD_ID);
    }
}
