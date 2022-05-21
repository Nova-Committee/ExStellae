package committee.nova.exstellae.common.data.recipes.types.init;

import committee.nova.exstellae.ExStellae;
import committee.nova.exstellae.common.data.recipes.types.impl.SieveRecipeType;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.registry.Registry;

public class RecipeTypeInit {
    public static final DeferredRegister<RecipeType<?>> TYPES = DeferredRegister.create(ExStellae.MOD_ID, Registry.RECIPE_TYPE_KEY);

    public static final RegistrySupplier<RecipeType<SieveRecipeType>> SIEVE_TYPE = TYPES.register(SieveRecipeType.Type.ID, () -> SieveRecipeType.Type.INSTANCE);
}
