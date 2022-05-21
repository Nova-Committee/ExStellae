package committee.nova.exstellae.common.blocks.blockentities.init;

import committee.nova.exstellae.ExStellae;
import committee.nova.exstellae.common.blocks.blockentities.impl.SieveBlockEntity;
import committee.nova.exstellae.common.blocks.init.BlockInit;
import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.datafixer.TypeReferences;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;

import java.util.List;
import java.util.function.BiFunction;

import static committee.nova.exstellae.ExStellae.MOD_ID;

public class BlockEntityInit {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(MOD_ID, Registry.BLOCK_ENTITY_TYPE_KEY);

    public static final RegistrySupplier<BlockEntityType<SieveBlockEntity>> SIEVE_BLOCK_ENTITY = register("sieve", SieveBlockEntity::new, List.of(BlockInit.OAK_SIEVE, BlockInit.ACACIA_SIEVE, BlockInit.BIRCH_SIEVE, BlockInit.JUNGLE_SIEVE, BlockInit.SPRUCE_SIEVE, BlockInit.DARK_OAK_SIEVE));

    static <T extends BlockEntity> RegistrySupplier<BlockEntityType<T>> register(String name, BiFunction<BlockPos, BlockState, T> factory, List<RegistrySupplier<Block>> suppliers) {
        Identifier id = new Identifier(ExStellae.MOD_ID, name);
        return BLOCK_ENTITIES.register(id, () -> BlockEntityType.Builder.create(
                factory::apply, suppliers.stream().map(RegistrySupplier::get).toArray(Block[]::new)
        ).build(Util.getChoiceType(TypeReferences.BLOCK_ENTITY, id.toString())));
    }
}
