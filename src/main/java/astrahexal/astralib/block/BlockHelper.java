package astrahexal.astralib.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.function.Function;

public class BlockHelper {
    private BlockHelper() {}

    public static BlockSetHelper.BlockDefinition registerBlock(
            String name,
            String modName,
            Function<BlockBehaviour.Properties, Block> properties
    ) {
        Identifier id = Identifier.fromNamespaceAndPath(modName, name);
        Block block = properties.apply(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(modName, name))));

        Registry.register(BuiltInRegistries.BLOCK, id, block);
        Registry.register(BuiltInRegistries.ITEM, id, new BlockItem(block, new Item.Properties()));

        return new BlockSetHelper.BlockDefinition(
                name,
                block
        );
    }
}
