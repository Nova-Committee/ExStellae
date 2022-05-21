package committee.nova.exstellae.common.data.recipes.serializers.impl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import committee.nova.exstellae.common.data.recipes.types.impl.SieveRecipeType;
import dev.architectury.core.RegistryEntry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class SieveRecipeSerializer extends RegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<SieveRecipeType> {
    private SieveRecipeSerializer() {
    }

    public static final String ID = "sieve";

    public static final SieveRecipeSerializer INSTANCE = new SieveRecipeSerializer();

    @Override
    public SieveRecipeType read(Identifier id, JsonObject json) {
        SieveRecipeType.RecipeJsonFormat recipeJson = new Gson().fromJson(json, SieveRecipeType.RecipeJsonFormat.class);
        if (recipeJson.input == null || recipeJson.outputItem == null || recipeJson.lootTable == null) {
            throw new JsonSyntaxException("A required attribute is missing!");
        }
        if (recipeJson.outputAmount == 0) recipeJson.outputAmount = 1;
        Ingredient input = Ingredient.fromJson(recipeJson.input);
        String lootTable = recipeJson.lootTable;
        Item outputItem = Registry.ITEM.getOrEmpty(new Identifier(recipeJson.outputItem)).orElseThrow(() -> new JsonSyntaxException("No such item " + recipeJson.outputItem));
        ItemStack output = new ItemStack(outputItem, recipeJson.outputAmount);
        return new SieveRecipeType(id, output, input, lootTable);
    }

    @Override
    public SieveRecipeType read(Identifier id, PacketByteBuf buf) {
        Ingredient input = Ingredient.fromPacket(buf);
        String lootTable = buf.readString();
        ItemStack output = buf.readItemStack();
        return new SieveRecipeType(id, output, input, lootTable);
    }

    @Override
    public void write(PacketByteBuf buf, SieveRecipeType recipe) {
        recipe.getInput().write(buf);
        buf.writeString(recipe.getLootTable());
        buf.writeItemStack(recipe.getOutput());
    }
}
