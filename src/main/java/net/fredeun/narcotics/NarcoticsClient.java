package net.fredeun.narcotics;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.fredeun.narcotics.block.ModBlocks;
import net.fredeun.narcotics.fluid.ModFluids;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class NarcoticsClient implements ClientModInitializer {


    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COCA_PLANT, RenderLayer.getCutout());

        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.SULFURIC_ACID, ModFluids.FLOWING_SULFURIC_ACID, new SimpleFluidRenderHandler(
                Identifier.of("minecraft:block/water_still"),
                Identifier.of("minecraft:block/water_flow"),
                0xfaefb9
        ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.SULFURIC_ACID, ModFluids.FLOWING_SULFURIC_ACID);



        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.COCA_SOLUTION, ModFluids.FLOWING_COCA_SOLUTION, new SimpleFluidRenderHandler(
                Identifier.of("minecraft:block/water_still"),
                Identifier.of("minecraft:block/water_flow"),
                0x295e37
        ));

        BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), ModFluids.COCA_SOLUTION, ModFluids.FLOWING_COCA_SOLUTION);
    }
}
