Block registration:

To register a stone set (base block, stairs, slab, and wall):
public static final BlockSetHelper.stoneBlockSet YOUR_BLOCK_NAME = BlockSetHelper.stoneSetProvider("your_block_name", YourMod.ModID, () -> BlockBehaviour.Properties.PROPRETIES);

Example:
public static final BlockSetHelper.stoneBlockSet MULSTONE = BlockSetHelper.stoneSetProvider("mulstone", Astralib.MOD_ID, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.STONE));


To register a wood set (base planks, stairs, slab, fence, fence gate, button, pressure plate, door, and trapdoor):
public static final BlockSetHelper.woodBlockSet YOUR_BLOCK_NAME = BlockSetHelper.woodSetProvider("your_block_name", YourMod.ModID, BlockSetType.WOOD_TYPE, 30, WoodType.WOOD_TYPE, () -> BlockBehaviour.Properties.PROPERTIES);

Example:
public static final BlockSetHelper.woodBlockSet AMBER = BlockSetHelper.woodSetProvider("amber", Astralib.MOD_ID, BlockSetType.WARPED, 30, WoodType.WARPED, () -> BlockBehaviour.Properties.ofFullCopy(Blocks.WARPED_PLANKS));
