package net.fredeun.narcotics.effect;

import net.fredeun.narcotics.NarcoticsMC;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import static net.fredeun.narcotics.NarcoticsMC.MOD_ID;

public class ModEffects {

    public static final RegistryEntry.Reference<StatusEffect> TEST_EFFECT = registerEffect("testeffect", new TestEffect(StatusEffectCategory.BENEFICIAL,4));
    public static RegistryEntry.Reference<StatusEffect> registerEffect(String name, StatusEffect effect){
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(MOD_ID,name),effect);
    }
    public static void registerModEffects(){
        NarcoticsMC.LOGGER.info("Registering Effects of " + MOD_ID);
    }
}
