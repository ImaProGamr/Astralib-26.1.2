package astrahexal.astralib.datagen;

import astrahexal.astralib.block.BlockSetHelper;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;

public class ModelProvider extends FabricModelProvider {
    public ModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockModelGenerators blockModelGenerators) {
        for (BlockSetHelper.stoneBlockSet set : BlockSetHelper.STONE_BLOCK_SETS) {
            blockModelGenerators.family(set.base())
                    .stairs(set.stairs())
                    .slab(set.slab())
                    .wall(set.wall());
        }
        for (BlockSetHelper.woodBlockSet set : BlockSetHelper.WOOD_BLOCK_SETS) {
            blockModelGenerators.family(set.base())
                    .stairs(set.stairs())
                    .slab(set.slab())
                    .fence(set.fence())
                    .fenceGate(set.fenceGate())
                    .button(set.button())
                    .pressurePlate(set.pressurePlate());
            blockModelGenerators.createDoor(set.door());
            blockModelGenerators.createTrapdoor(set.trapdoor());
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {

    }
}
