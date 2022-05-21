package committee.nova.exstellae.common.data.recipes.types.impl;

import com.google.gson.JsonObject;
import committee.nova.exstellae.common.data.recipes.serializers.impl.SieveRecipeSerializer;
import committee.nova.exstellae.common.utils.inv.InventoryImpl;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class SieveRecipeType implements Recipe<InventoryImpl> {
    private final Ingredient input;
    private final ItemStack result;
    private final String lootTable;
    private final Identifier id;

    public SieveRecipeType(Identifier id, ItemStack result, Ingredient input, String lootTable) {
        this.id = id;
        this.result = result;
        this.input = input;
        this.lootTable = lootTable;
    }

    public Ingredient getInput() {
        return this.input;
    }

    public String getLootTable() {
        return this.lootTable;
    }

    @Override
    public boolean matches(InventoryImpl inventory, World world) {
        if(inventory.size() < 1) return false;
        return input.test(inventory.getStack(0));
    }

    @Override
    public ItemStack craft(InventoryImpl inventory) {
        return ItemStack.EMPTY;
    }

    @Override
    public boolean fits(int width, int height) {
        return false;
    }

    @Override
    public ItemStack getOutput() {
        return result;
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return SieveRecipeSerializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<SieveRecipeType> {
        private Type() {}
        public static final Type INSTANCE = new Type();
        public static final String ID = "sieve";
    }

    public class RecipeJsonFormat {
        public JsonObject input;
        public String lootTable;
        public String outputItem;
        public int outputAmount;
    }
}
