package committee.nova.exstellae.common.data.tags.init;

import net.minecraft.item.Item;
import net.minecraft.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static committee.nova.exstellae.ExStellae.MOD_ID;

public class TagInit {
    public static final TagKey<Item> SIEVE_PROCESSABLE = TagKey.of(Registry.ITEM_KEY, new Identifier(MOD_ID, "misc/sieve_processable"));
}
