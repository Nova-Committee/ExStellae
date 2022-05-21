package committee.nova.exstellae.common.items.impl;

import committee.nova.exstellae.common.items.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.particle.BlockStateParticleEffect;
import net.minecraft.particle.ItemStackParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class HookItem extends ToolItem implements Vanishable {
    public HookItem(ToolMaterial material, Settings settings) {
        super(material, settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        ActionResult ar = ActionResult.PASS;
        World world = context.getWorld();
        if (!world.isClient()) {
            PlayerEntity player = context.getPlayer();
            BlockPos pos = context.getBlockPos();
            Block block = world.getBlockState(pos).getBlock();
            ItemStack stack = context.getStack();
            Random random = new Random();
            if (block instanceof LeavesBlock) {
                for (int i = 0; i < random.nextInt(3, 5); i++) {
                    block.dropStack(world, pos, ItemInit.LEAVES.get().getDefaultStack());
                }
                world.playSound(null, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_SMALL_DRIPLEAF_BREAK, SoundCategory.BLOCKS, 1.0f, 1.0f);
                world.addParticle(new BlockStateParticleEffect(ParticleTypes.BLOCK, world.getBlockState(pos)), pos.getX(), pos.getY(), pos.getZ(), pos.getX(), pos.getY(), pos.getZ());
                world.removeBlock(pos, false);
                if (!player.isCreative()) {
                    stack.damage(1, player.getRandom(), (ServerPlayerEntity) player);
                }
                if (stack.getDamage() > stack.getMaxDamage()) {
                    stack.decrement(1);
                    world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_SHIELD_BREAK, SoundCategory.VOICE, 1.0f, 1.0f);
                    world.addParticle(new ItemStackParticleEffect(ParticleTypes.ITEM, stack), player.getX(), player.getY(), player.getZ(), player.getX(), player.getY(), player.getZ());
                }
                ar = ActionResult.SUCCESS;
            }
        }
        return ar;
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        stack.damage(1, attacker, (e) -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        return true;
    }

    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (state.getHardness(world, pos) != 0.0F) {
            stack.damage(1, miner, (e) -> e.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND));
        }
        return true;
    }

    @Override
    public boolean isSuitableFor(BlockState state) {
        Block block = state.getBlock();
        return block instanceof LeavesBlock ? state.isOf(block) : false;
    }
}
