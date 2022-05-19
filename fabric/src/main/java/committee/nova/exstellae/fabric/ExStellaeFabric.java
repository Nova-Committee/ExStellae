package committee.nova.exstellae.fabric;

import committee.nova.exstellae.ExStellae;
import net.fabricmc.api.ModInitializer;

public class ExStellaeFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ExStellae.init();
    }
}
