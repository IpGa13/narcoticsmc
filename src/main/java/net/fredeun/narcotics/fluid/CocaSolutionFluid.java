package net.fredeun.narcotics.fluid;

import net.fredeun.narcotics.block.ModBlocks;
import net.fredeun.narcotics.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.world.WorldView;

public abstract class CocaSolutionFluid extends AbstractModFluid {
    @Override
    public Fluid getStill() {
        return ModFluids.COCA_SOLUTION;
    }

    @Override
    public Fluid getFlowing() {
        return ModFluids.FLOWING_COCA_SOLUTION;
    }

    @Override
    public Item getBucketItem() {
        return ModItems.COCA_SOLUTION_BUCKET;
    }


    @Override
    protected BlockState toBlockState(FluidState fluidState) {
        // getBlockStateLevel converts the LEVEL_1_8 of the fluid state to the LEVEL_15 the fluid block uses
        return ModBlocks.COCA_SOLUTION.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
    }

    @Override
    protected int getMaxFlowDistance(WorldView world) {
        return 8;
    }

    @Override
    public int getTickRate(WorldView world) {
        return 5;
    }

    public static class Flowing extends CocaSolutionFluid {
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState fluidState) {
            return fluidState.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return false;
        }
    }

    public static class Still extends CocaSolutionFluid {
        @Override
        public int getLevel(FluidState fluidState) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return true;
        }
    }
}
