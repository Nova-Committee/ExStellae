package committee.nova.exstellae.forge;

import committee.nova.exstellae.ExStellae;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ExStellae.MOD_ID)
public class ExStellaeForge {
    public ExStellaeForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(ExStellae.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        ExStellae.init();
    }
}
