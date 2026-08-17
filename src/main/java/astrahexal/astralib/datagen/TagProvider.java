package astrahexal.astralib.datagen;

import astrahexal.astralib.block.BlockSetHelper;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;

import java.util.concurrent.CompletableFuture;

public class TagProvider extends FabricTagsProvider.BlockTagsProvider {
    public TagProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider registries) {
        for(BlockSetHelper.stoneBlockSet set : BlockSetHelper.STONE_BLOCK_SETS) {
            valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
                    .add(set.base())
                    .add(set.stairs())
                    .add(set.slab())
                    .add(set.wall());
            valueLookupBuilder(BlockTags.STAIRS).add(set.stairs());
            valueLookupBuilder(BlockTags.SLABS).add(set.slab());
            valueLookupBuilder(BlockTags.WALLS).add(set.wall());
        }
        for(BlockSetHelper.woodBlockSet set : BlockSetHelper.WOOD_BLOCK_SETS) {
            valueLookupBuilder(BlockTags.MINEABLE_WITH_AXE)
                    .add(set.base())
                    .add(set.stairs())
                    .add(set.slab())
                    .add(set.fence())
                    .add(set.fenceGate())
                    .add(set.button())
                    .add(set.pressurePlate())
                    .add(set.door())
                    .add(set.trapdoor());
            valueLookupBuilder(BlockTags.WOODEN_STAIRS).add(set.stairs());
            valueLookupBuilder(BlockTags.WOODEN_SLABS).add(set.slab());
            valueLookupBuilder(BlockTags.WOODEN_FENCES).add(set.fence());
            valueLookupBuilder(BlockTags.FENCE_GATES).add(set.fenceGate());
            valueLookupBuilder(BlockTags.WOODEN_BUTTONS).add(set.button());
            valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(set.pressurePlate());
            valueLookupBuilder(BlockTags.WOODEN_DOORS).add(set.door());
            valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS).add(set.trapdoor());
        }
    }
}
