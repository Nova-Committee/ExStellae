package committee.nova.exstellae.common.data.recipes.serializers.init;

import committee.nova.exstellae.ExStellae;
import committee.nova.exstellae.common.data.recipes.serializers.impl.SieveRecipeSerializer;
import committee.nova.exstellae.common.data.recipes.types.impl.SieveRecipeType;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.registry.Registry;

public class RecipeSerializerInit {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ExStellae.MOD_ID, Registry.RECIPE_SERIALIZER_KEY);

    public static final RegistrySupplier<RecipeSerializer<SieveRecipeType>> SIEVE_SRL = SERIALIZERS.register(SieveRecipeSerializer.ID, () -> SieveRecipeSerializer.INSTANCE);
}
