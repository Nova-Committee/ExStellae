package committee.nova.exstellae.common.items.init;

import committee.nova.exstellae.common.blocks.init.BlockInit;
import committee.nova.exstellae.common.items.impl.HookItem;
import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static committee.nova.exstellae.ExStellae.MOD_ID;

public class ItemInit {
    public static final ItemGroup GROUP = CreativeTabRegistry.create(new Identifier(MOD_ID, "main"), () ->
            new ItemStack(ItemInit.COPPER_ORE_CHUNK.get()));

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(MOD_ID, Registry.ITEM_KEY);

    public static final RegistrySupplier<Item> COPPER_ORE_CHUNK = ITEMS.register("copper_ore_chunk", () ->
            new Item(new Item.Settings().group(ItemInit.GROUP)));
    public static final RegistrySupplier<Item> IRON_ORE_CHUNK = ITEMS.register("iron_ore_chunk", () ->
            new Item(new Item.Settings().group(ItemInit.GROUP)));
    public static final RegistrySupplier<Item> GOLD_ORE_CHUNK = ITEMS.register("gold_ore_chunk", () ->
            new Item(new Item.Settings().group(ItemInit.GROUP)));
    public static final RegistrySupplier<Item> DIAMOND_ORE_CHUNK = ITEMS.register("diamond_ore_chunk", () ->
            new Item(new Item.Settings().group(ItemInit.GROUP)));
    public static final RegistrySupplier<Item> EMERALD_ORE_CHUNK = ITEMS.register("emerald_ore_chunk", () ->
            new Item(new Item.Settings().group(ItemInit.GROUP)));

    public static final RegistrySupplier<Item> COPPER_ORE_PIECE = ITEMS.register("copper_ore_piece", () ->
            new Item(new Item.Settings().group(ItemInit.GROUP)));
    public static final RegistrySupplier<Item> IRON_ORE_PIECE = ITEMS.register("iron_ore_piece", () ->
            new Item(new Item.Settings().group(ItemInit.GROUP)));
    public static final RegistrySupplier<Item> GOLD_ORE_PIECE = ITEMS.register("gold_ore_piece", () ->
            new Item(new Item.Settings().group(ItemInit.GROUP)));
    public static final RegistrySupplier<Item> DIAMOND_ORE_PIECE = ITEMS.register("diamond_ore_piece", () ->
            new Item(new Item.Settings().group(ItemInit.GROUP)));
    public static final RegistrySupplier<Item> EMERALD_ORE_PIECE = ITEMS.register("emerald_ore_piece", () ->
            new Item(new Item.Settings().group(ItemInit.GROUP)));
    public static final RegistrySupplier<Item> FLINT_PIECE = ITEMS.register("flint_piece", () ->
            new Item(new Item.Settings().group(ItemInit.GROUP)));
    public static final RegistrySupplier<Item> PURE_SAND_DUST = ITEMS.register("pure_sand_dust", () ->
            new Item(new Item.Settings().group(ItemInit.GROUP)));
    public static final RegistrySupplier<Item> PURE_RED_SAND_DUST = ITEMS.register("pure_red_sand_dust", () ->
            new Item(new Item.Settings().group(ItemInit.GROUP)));
    public static final RegistrySupplier<Item> SMALL_COBBLE = ITEMS.register("small_cobble", () ->
            new Item(new Item.Settings().group(ItemInit.GROUP)));

    public static final RegistrySupplier<Item> LEAVES = ITEMS.register("leaves", () ->
            new Item(new Item.Settings().group(ItemInit.GROUP)));
    public static final RegistrySupplier<Item> FIBER_STRING = ITEMS.register("fiber_string", () ->
            new Item(new Item.Settings().group(ItemInit.GROUP)));

    public static final RegistrySupplier<Item> MESH = ITEMS.register("mesh", () ->
            new Item(new Item.Settings().group(ItemInit.GROUP)));

    public static final RegistrySupplier<Item> OAK_SIEVE = ITEMS.register("oak_sieve", () ->
            new BlockItem(BlockInit.OAK_SIEVE.get(), new Item.Settings().group(ItemInit.GROUP)));
    public static final RegistrySupplier<Item> ACACIA_SIEVE = ITEMS.register("acacia_sieve", () ->
            new BlockItem(BlockInit.ACACIA_SIEVE.get(), new Item.Settings().group(ItemInit.GROUP)));
    public static final RegistrySupplier<Item> BIRCH_SIEVE = ITEMS.register("birch_sieve", () ->
            new BlockItem(BlockInit.BIRCH_SIEVE.get(), new Item.Settings().group(ItemInit.GROUP)));
    public static final RegistrySupplier<Item> DARK_OAK_SIEVE = ITEMS.register("dark_oak_sieve", () ->
            new BlockItem(BlockInit.DARK_OAK_SIEVE.get(), new Item.Settings().group(ItemInit.GROUP)));
    public static final RegistrySupplier<Item> SPRUCE_SIEVE = ITEMS.register("spruce_sieve", () ->
            new BlockItem(BlockInit.SPRUCE_SIEVE.get(), new Item.Settings().group(ItemInit.GROUP)));
    public static final RegistrySupplier<Item> JUNGLE_SIEVE = ITEMS.register("jungle_sieve", () ->
            new BlockItem(BlockInit.JUNGLE_SIEVE.get(), new Item.Settings().group(ItemInit.GROUP)));

    public static final RegistrySupplier<Item> WOODEN_HOOK = ITEMS.register("wooden_hook", () ->
            new HookItem(ToolMaterials.WOOD, new Item.Settings().group(ItemInit.GROUP).maxDamage(50)));
}
