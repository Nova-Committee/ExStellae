package committee.nova.exstellae.common.blocks.impl;

import committee.nova.exstellae.common.blocks.blockentities.impl.SieveBlockEntity;
import committee.nova.exstellae.common.blocks.blockentities.init.BlockEntityInit;
import committee.nova.exstellae.common.utils.inv.InventoryImpl;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class SieveBlock extends BlockWithEntity {

    private final VoxelShape SHAPE = VoxelShapes.union(VoxelShapes.cuboid(0, 0.9375, 0, 1, 1.0625, 1), VoxelShapes.cuboid(0, 0, 0, 0.125, 0.9375, 0.125), VoxelShapes.cuboid(0.875, 0, 0, 1, 0.9375, 0.125), VoxelShapes.cuboid(0.875, 0, 0.875, 1, 0.9375, 1), VoxelShapes.cuboid(0, 0, 0.875, 0.125, 0.9375, 1));

    public SieveBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) return ActionResult.SUCCESS;
        InventoryImpl blockEntity = (InventoryImpl) world.getBlockEntity(pos);
        if (!player.getStackInHand(hand).isEmpty()) {
            if (blockEntity.getStack(0).isEmpty()) {
                ItemStack stack = new ItemStack(player.getStackInHand(hand).getItem(), 1);
                blockEntity.setStack(0, stack);
                if (!player.isCreative()) player.getStackInHand(hand).decrement(1);
            } else {
                if (!blockEntity.getStack(0).isEmpty()) {
                    player.getInventory().offerOrDrop(blockEntity.getStack(0));
                    blockEntity.removeStack(0, 1);
                }
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Deprecated
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SieveBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, BlockEntityInit.SIEVE_BLOCK_ENTITY.get(), SieveBlockEntity::tick);
    }
}
