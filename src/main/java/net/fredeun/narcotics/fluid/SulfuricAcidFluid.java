package net.fredeun.narcotics.fluid;

import net.fredeun.narcotics.block.ModBlocks;
import net.fredeun.narcotics.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.WaterFluid;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.*;

import java.util.Optional;

public abstract class SulfuricAcidFluid extends AbstractModFluid {
    @Override
    public Fluid getStill() {
        return ModFluids.SULFURIC_ACID;
    }

    @Override
    public Fluid getFlowing() {
        return ModFluids.FLOWING_SULFURIC_ACID;
    }

    @Override
    public Item getBucketItem() {
        return ModItems.SULFURIC_ACID_BUCKET;
    }


    @Override
    protected BlockState toBlockState(FluidState fluidState) {
        // getBlockStateLevel converts the LEVEL_1_8 of the fluid state to the LEVEL_15 the fluid block uses
        return ModBlocks.SULFURIC_ACID_BLOCK.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(fluidState));
    }

    @Override
    protected int getMaxFlowDistance(WorldView world) {
        return 8;
    }

    @Override
    public int getTickRate(WorldView world) {
        return 5;
    }

    public static class Flowing extends SulfuricAcidFluid {
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

    public static class Still extends SulfuricAcidFluid {
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
