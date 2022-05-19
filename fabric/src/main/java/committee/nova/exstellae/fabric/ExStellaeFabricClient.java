package committee.nova.exstellae.fabric;

import committee.nova.exstellae.common.blocks.init.BlockInit;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;

public class ExStellaeFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.OAK_SIEVE.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.ACACIA_SIEVE.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.BIRCH_SIEVE.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.DARK_OAK_SIEVE.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.SPRUCE_SIEVE.get(), RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockInit.JUNGLE_SIEVE.get(), RenderLayer.getCutout());
    }
}
