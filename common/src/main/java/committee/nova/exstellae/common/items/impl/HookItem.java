package committee.nova.exstellae.common.items.impl;

import committee.nova.exstellae.common.items.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class HookItem extends ToolItem {
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
                world.removeBlock(pos, false);
                if (!player.isCreative()) {
                    stack.damage(1, player.getRandom(), (ServerPlayerEntity) player);
                }
                ar = ActionResult.SUCCESS;
            }
        }
        return ar;
    }
}
