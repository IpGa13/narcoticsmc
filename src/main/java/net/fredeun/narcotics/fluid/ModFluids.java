package net.fredeun.narcotics.fluid;

import net.fredeun.narcotics.NarcoticsMC;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

import static net.fredeun.narcotics.NarcoticsMC.MOD_ID;

public class ModFluids {


    public static final FlowableFluid SULFURIC_ACID = registerFluid("sulfuric_acid", new SulfuricAcidFluid.Still());
    public static final FlowableFluid FLOWING_SULFURIC_ACID = registerFluid("flowing_sulfuric_acid", new SulfuricAcidFluid.Flowing());

    public static final FlowableFluid COCA_SOLUTION = registerFluid("coca_solution", new CocaSolutionFluid.Still());
    public static final FlowableFluid FLOWING_COCA_SOLUTION = registerFluid("flowing_coca_solution", new CocaSolutionFluid.Flowing());

    private static <T extends Fluid> T registerFluid(String name, T value) {
        return Registry.register(Registries.FLUID, Identifier.of(MOD_ID,name), value);
    }

    public static void registerModFluids() {
        NarcoticsMC.LOGGER.info("Registering Fluids of "+MOD_ID);
    }
}
