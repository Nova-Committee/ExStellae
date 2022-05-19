package committee.nova.exstellae.common.items;

import dev.architectury.registry.CreativeTabRegistry;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
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
    public static final RegistrySupplier<Item> COAL_ORE_CHUNK = ITEMS.register("coal_ore_chunk", () ->
            new Item(new Item.Settings().group(ItemInit.GROUP)));
}
