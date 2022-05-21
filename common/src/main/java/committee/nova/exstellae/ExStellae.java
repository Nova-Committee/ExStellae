package committee.nova.exstellae;

import committee.nova.exstellae.common.blocks.blockentities.init.BlockEntityInit;
import committee.nova.exstellae.common.blocks.init.BlockInit;
import committee.nova.exstellae.common.data.recipes.serializers.init.RecipeSerializerInit;
import committee.nova.exstellae.common.data.recipes.types.init.RecipeTypeInit;
import committee.nova.exstellae.common.items.init.ItemInit;

public class ExStellae {
    public static final String MOD_ID = "exstellae";
    
    public static void init() {
        BlockInit.BLOCKS.register();
        BlockEntityInit.BLOCK_ENTITIES.register();
        ItemInit.ITEMS.register();
        RecipeTypeInit.TYPES.register();
        RecipeSerializerInit.SERIALIZERS.register();
    }
}
