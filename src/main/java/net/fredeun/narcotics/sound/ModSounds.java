package net.fredeun.narcotics.sound;

import net.fredeun.narcotics.NarcoticsMC;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import static net.fredeun.narcotics.NarcoticsMC.MOD_ID;

public class ModSounds {

    public static final SoundEvent SNORT = registerSoundEvent("snort");
    public static SoundEvent registerSoundEvent(String name) {
        Identifier id = Identifier.of(MOD_ID,name);
        return Registry.register(Registries.SOUND_EVENT,id,SoundEvent.of(id));
    }
    public static void registerModSounds() {
        NarcoticsMC.LOGGER.info("Registering Blocks for " + MOD_ID);
    }
}
