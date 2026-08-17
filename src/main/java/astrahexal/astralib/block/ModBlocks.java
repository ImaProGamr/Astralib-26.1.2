package astrahexal.astralib.block;

import astrahexal.astralib.Astralib;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.logging.Logger;

public class ModBlocks {
    public static final BlockSetHelper.stoneBlockSet MULSTONE = BlockSetHelper.stoneSetProvider("mulstone", Astralib.MOD_ID, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));
    public static final BlockSetHelper.woodBlockSet AMBER = BlockSetHelper.woodSetProvider("amber", Astralib.MOD_ID, BlockSetType.WARPED, 30, WoodType.WARPED, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS));

    public static void registerBlocks() {
        Logger.getLogger("Registering Blocks");
    }
}
