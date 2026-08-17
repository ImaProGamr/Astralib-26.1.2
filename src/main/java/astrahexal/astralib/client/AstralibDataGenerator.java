package astrahexal.astralib.client;

import astrahexal.astralib.datagen.LangProvider;
import astrahexal.astralib.datagen.ModelProvider;
import astrahexal.astralib.datagen.TagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class AstralibDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(ModelProvider::new);
        pack.addProvider(LangProvider::new);
        pack.addProvider(TagProvider::new);
    }
}
