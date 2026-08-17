package astrahexal.astralib;

import astrahexal.astralib.block.BlockSetHelper;
import astrahexal.astralib.block.ModBlocks;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Astralib implements ModInitializer {
    public static final String MOD_ID = "astralib";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModBlocks.registerBlocks();
        BlockSetHelper.registerBlockSetHelper();
    }
}
