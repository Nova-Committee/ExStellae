package committee.nova.exstellae;

import committee.nova.exstellae.common.blocks.init.BlockInit;
import committee.nova.exstellae.common.items.init.ItemInit;

public class ExStellae {
    public static final String MOD_ID = "exstellae";
    
    public static void init() {
        BlockInit.BLOCKS.register();
        ItemInit.ITEMS.register();
    }
}
