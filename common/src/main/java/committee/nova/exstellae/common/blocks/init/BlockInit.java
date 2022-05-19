package committee.nova.exstellae.common.blocks.init;

import committee.nova.exstellae.common.blocks.impl.SieveBlock;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.util.registry.Registry;

import static committee.nova.exstellae.ExStellae.MOD_ID;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(MOD_ID, Registry.BLOCK_KEY);

    public static final RegistrySupplier<Block> OAK_SIEVE = BLOCKS.register("oak_sieve", () ->
            new SieveBlock(Block.Settings.of(Material.WOOD, MapColor.BROWN).hardness(1.0f)));
    public static final RegistrySupplier<Block> ACACIA_SIEVE = BLOCKS.register("acacia_sieve", () ->
            new SieveBlock(Block.Settings.of(Material.WOOD, MapColor.BROWN).hardness(1.0f)));
    public static final RegistrySupplier<Block> BIRCH_SIEVE = BLOCKS.register("birch_sieve", () ->
            new SieveBlock(Block.Settings.of(Material.WOOD, MapColor.BROWN).hardness(1.0f)));
    public static final RegistrySupplier<Block> DARK_OAK_SIEVE = BLOCKS.register("dark_oak_sieve", () ->
            new SieveBlock(Block.Settings.of(Material.WOOD, MapColor.BROWN).hardness(1.0f)));
    public static final RegistrySupplier<Block> SPRUCE_SIEVE = BLOCKS.register("spruce_sieve", () ->
            new SieveBlock(Block.Settings.of(Material.WOOD, MapColor.BROWN).hardness(1.0f)));
    public static final RegistrySupplier<Block> JUNGLE_SIEVE = BLOCKS.register("jungle_sieve", () ->
            new SieveBlock(Block.Settings.of(Material.WOOD, MapColor.BROWN).hardness(1.0f)));
}
