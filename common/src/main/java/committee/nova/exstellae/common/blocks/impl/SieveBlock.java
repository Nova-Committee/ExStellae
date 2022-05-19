package committee.nova.exstellae.common.blocks.impl;

import committee.nova.exstellae.common.data.loot.init.LootTableInit;
import committee.nova.exstellae.common.data.tags.init.TagInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextParameters;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.List;

public class SieveBlock extends Block {
    public SieveBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.SUCCESS;
        } else {
            if (player.getMainHandStack().isIn(TagInit.SIEVE_PROCESSABLE)) {
                LootTable loot = world.getServer().getLootManager().getTable(LootTableInit.SIEVE_LOOT);
                LootContext lootContext = (new LootContext.Builder((ServerWorld) world)).parameter(LootContextParameters.THIS_ENTITY, player).parameter(LootContextParameters.ORIGIN, new Vec3d(pos.getX(), pos.getY(), pos.getZ())).parameter(LootContextParameters.TOOL, player.getStackInHand(hand)).parameter(LootContextParameters.BLOCK_STATE, this.getDefaultState()).build(LootContextTypes.BLOCK);
                List<ItemStack> lootStacks = loot.generateLoot(lootContext);
                for (ItemStack lootStack : lootStacks) {
                    dropStack(world, pos, lootStack);
                }
                world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_GRAVEL_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f);
                if (!player.isCreative()) {
                    player.getStackInHand(hand).decrement(1);
                }
                return ActionResult.CONSUME;
            } else {
                return ActionResult.PASS;
            }
        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return VoxelShapes.union(VoxelShapes.cuboid(0, 0.9375, 0, 1, 1.0625, 1), VoxelShapes.cuboid(0, 0, 0, 0.125, 0.9375, 0.125), VoxelShapes.cuboid(0.875, 0, 0, 1, 0.9375, 0.125), VoxelShapes.cuboid(0.875, 0, 0.875, 1, 0.9375, 1), VoxelShapes.cuboid(0, 0, 0.875, 0.125, 0.9375, 1));
    }
}
