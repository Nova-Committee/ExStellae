package committee.nova.exstellae.forge;

import committee.nova.exstellae.ExStellae;
import committee.nova.exstellae.common.blocks.init.BlockInit;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = ExStellae.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ExStellaeForgeClient {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        RenderLayers.setRenderLayer(BlockInit.OAK_SIEVE.get(), RenderLayer.getCutout());
        RenderLayers.setRenderLayer(BlockInit.ACACIA_SIEVE.get(), RenderLayer.getCutout());
        RenderLayers.setRenderLayer(BlockInit.BIRCH_SIEVE.get(), RenderLayer.getCutout());
        RenderLayers.setRenderLayer(BlockInit.DARK_OAK_SIEVE.get(), RenderLayer.getCutout());
        RenderLayers.setRenderLayer(BlockInit.SPRUCE_SIEVE.get(), RenderLayer.getCutout());
        RenderLayers.setRenderLayer(BlockInit.JUNGLE_SIEVE.get(), RenderLayer.getCutout());
    }
}
