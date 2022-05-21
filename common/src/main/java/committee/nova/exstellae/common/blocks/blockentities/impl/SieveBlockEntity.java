package committee.nova.exstellae.common.blocks.blockentities.impl;

import committee.nova.exstellae.common.blocks.blockentities.init.BlockEntityInit;
import committee.nova.exstellae.common.data.recipes.types.impl.SieveRecipeType;
import committee.nova.exstellae.common.utils.inv.InventoryImpl;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;
import java.util.Optional;

public class SieveBlockEntity extends BlockEntity implements InventoryImpl, SidedInventory {
    private final DefaultedList<ItemStack> items = DefaultedList.ofSize(1, ItemStack.EMPTY);

    public SieveBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntityInit.SIEVE_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return items;
    }

    @Override
    public void readNbt(NbtCompound nbt) {
        super.readNbt(nbt);
        Inventories.readNbt(nbt, items);
    }

    @Override
    public void writeNbt(NbtCompound nbt) {
        super.writeNbt(nbt);
        Inventories.writeNbt(nbt, items);
    }

    @Override
    public int[] getAvailableSlots(Direction var1) {
        int[] result = new int[getItems().size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = i;
        }
        return result;
    }

    @Override
    public boolean canInsert(int slot, ItemStack stack, Direction direction) {
        return direction == Direction.UP;
    }

    @Override
    public boolean canExtract(int slot, ItemStack stack, Direction direction) {
        return true;
    }

    public static void tick(World world, BlockPos pos, BlockState state, SieveBlockEntity be) {
        if (!world.isClient()) {
            InventoryImpl inventory = InventoryImpl.of(be.getItems());
            Optional<SieveRecipeType> match = world.getRecipeManager().getFirstMatch(SieveRecipeType.Type.INSTANCE, inventory, world);
            if (match.isPresent()) {
                LootTable loot = world.getServer().getLootManager().getTable(new Identifier(match.get().getLootTable()));
                LootContext lootContext = (new LootContext.Builder((ServerWorld) world)).parameter(LootContextParameters.THIS_ENTITY, world.getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 8.0d, false)).parameter(LootContextParameters.ORIGIN, new Vec3d(pos.getX(), pos.getY(), pos.getZ())).parameter(LootContextParameters.TOOL, inventory.getStack(0)).parameter(LootContextParameters.BLOCK_STATE, state).build(LootContextTypes.BLOCK);
                List<ItemStack> lootStacks = loot.generateLoot(lootContext);
                for (ItemStack lootStack : lootStacks) {
                    state.getBlock().dropStack(world, pos, lootStack);
                }
                state.getBlock().dropStack(world, pos, match.get().getOutput().copy());
                world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_GRAVEL_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f);
                inventory.removeStack(0, 1);
            }
        }
    }
}
