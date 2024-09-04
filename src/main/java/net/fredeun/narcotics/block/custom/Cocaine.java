package net.fredeun.narcotics.block.custom;

import net.fredeun.narcotics.effect.ModEffects;
import net.fredeun.narcotics.item.ModItems;
import net.fredeun.narcotics.sound.ModSounds;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Cocaine extends Block {
    public Cocaine(Settings settings) {
        super(settings);
    }
    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!(player.isHolding(ModItems.CASH_ITEM))){
            return ItemActionResult.FAIL;
        }
        world.playSoundAtBlockCenter(pos, ModSounds.SNORT, SoundCategory.BLOCKS, 1.0f, 1.0f, true);
        world.removeBlock(pos,false);
        player.addStatusEffect(new StatusEffectInstance(ModEffects.TEST_EFFECT,20*60*5,1));

        return ItemActionResult.CONSUME;
    }
}
