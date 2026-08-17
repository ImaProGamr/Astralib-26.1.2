package astrahexal.astralib.block;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class BlockSetHelper {
    public static final List<stoneBlockSet> STONE_BLOCK_SETS = new ArrayList<>();
    public static final List<woodBlockSet> WOOD_BLOCK_SETS = new ArrayList<>();

    public static List<stoneBlockSet> getStoneBlockSets() {
        return STONE_BLOCK_SETS;
    }
    public static List<woodBlockSet> getWoodBlockSets() { return WOOD_BLOCK_SETS; }

    public record BlockDefinition(
            String name,
            Block base
    ) {}

    public record stoneBlockSet(String name, String modName, Block base, Block stairs, Block slab, Block wall) { }
    public record woodBlockSet(String name, String modName, Block base, Block stairs, Block slab, Block fence, Block fenceGate, Block button, Block pressurePlate, Block door, Block trapdoor) {}

    public static stoneBlockSet stoneSetProvider(
            String name,
            String modName,
            Supplier<BlockBehaviour.Properties> properties
    ) {
        Block base = registerBlock(name, modName, Block::new, properties.get());
        Block stairs = registerBlock(name + "_stairs", modName, properties1 -> new StairBlock(base.defaultBlockState(), properties1), properties.get());
        Block slab = registerBlock(name + "_slab", modName, SlabBlock::new, properties.get());
        Block wall = registerBlock(name + "_wall", modName, WallBlock::new, properties.get());

        stoneBlockSet set  = new stoneBlockSet(name, modName, base, stairs, slab, wall);
        STONE_BLOCK_SETS.add(set);
        return set;
    }

    public static woodBlockSet woodSetProvider(
            String name,
            String modName,
            BlockSetType blockSetType,
            Integer buttonTicks,
            WoodType woodType,
            Supplier<BlockBehaviour.Properties> properties
    ) {
        Block base = registerBlock(name + "_planks", modName, Block::new, properties.get());
        Block stairs = registerBlock(name + "_stairs", modName, properties1 -> new StairBlock(base.defaultBlockState(), properties1), properties.get());
        Block slab = registerBlock(name + "_slab", modName, SlabBlock::new, properties.get());
        Block fence = registerBlock(name + "_fence", modName, FenceBlock::new, properties.get());
        Block fenceGate = registerBlock(name + "_fence_gate", modName, properties1 -> new FenceGateBlock(woodType, properties1), properties.get());
        Block button = registerBlock(name + "_button", modName, properties1 -> new ButtonBlock(blockSetType, buttonTicks, properties1), properties.get());
        Block pressurePlate = registerBlock(name + "_pressure_plate", modName, properties1 -> new PressurePlateBlock(blockSetType, properties1), properties.get().noCollision().forceSolidOn());
        Block door = registerBlock(name + "_door", modName, properties1 -> new DoorBlock(blockSetType, properties1), properties.get().noOcclusion());
        Block trapdoor = registerBlock(name + "_trapdoor", modName, properties1 -> new TrapDoorBlock(blockSetType, properties1), properties.get().noOcclusion());

        woodBlockSet set = new woodBlockSet(name, modName, base, stairs, slab, fence, fenceGate, button, pressurePlate, door, trapdoor);
        WOOD_BLOCK_SETS.add(set);
        return set;
    }

    public static Block registerBlock(String name, String modName, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties properties) {
        Identifier id = Identifier.fromNamespaceAndPath(modName, name);
        ResourceKey<Block> blockKey = ResourceKey.create(Registries.BLOCK, id);
        ResourceKey<Item> itemKey = ResourceKey.create(Registries.ITEM, id);
        Block block = factory.apply(properties.setId(blockKey));

        Registry.register(BuiltInRegistries.BLOCK, id, block);
        Registry.register(BuiltInRegistries.ITEM, id, new BlockItem(block, new Item.Properties().setId(itemKey)));

        return block;
    }

    public static void registerBlockSetHelper() {}
}
