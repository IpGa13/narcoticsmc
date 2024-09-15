package net.fredeun.narcotics.block.custom;

import com.mojang.serialization.MapCodec;
import net.fredeun.narcotics.NarcoticsMC;
import net.fredeun.narcotics.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.PlantBlock;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.state.property.Property;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class CocaPlant extends PlantBlock {
    public CocaPlant(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(AGE, 0));
    }

    public static Property AGE = Properties.AGE_3;

    @Override
    protected MapCodec<? extends PlantBlock> getCodec() {
        return null;
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        Integer i = (Integer) state.get(AGE);
        // nothing modclass.LOGGER.info("randomtickage"+String.valueOf(i));
        if (i < 3) {
            BlockState blockState = state.with(AGE, Integer.valueOf(i + 1));
            world.setBlockState(pos, blockState, Block.NOTIFY_LISTENERS);
            world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(blockState));
            return;
        }
        world.spawnEntity(new ItemEntity(world, pos.getX(),pos.getY(),pos.getZ(), ModItems.COCA_LEAF.getDefaultStack()));
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        player.sendMessage(Text.of("clicked plant"));
        return super.onUse(state, world, pos, player, hit);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }
}
