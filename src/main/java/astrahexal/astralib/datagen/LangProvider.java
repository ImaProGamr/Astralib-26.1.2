package astrahexal.astralib.datagen;

import astrahexal.astralib.block.BlockSetHelper;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class LangProvider extends FabricLanguageProvider {
    public LangProvider(FabricPackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
        super(packOutput, registries);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder translationBuilder) {
        for (BlockSetHelper.stoneBlockSet set : BlockSetHelper.getStoneBlockSets()) {
            String name = formatName(set.name());

            translationBuilder.add(set.base(), name);
            translationBuilder.add(set.stairs(), name + " Stairs");
            translationBuilder.add(set.slab(), name + " Slab");
            translationBuilder.add(set.wall(), name + " Wall");

            translationBuilder.add("item." + set.modName() + "." + set.name(), name);
            translationBuilder.add("item." + set.modName() + "." + set.name() + "_stairs", name + " Stairs");
            translationBuilder.add("item." + set.modName() + "." + set.name() + "_slab", name + " Slab");
            translationBuilder.add("item." + set.modName() + "." + set.name() + "_wall", name + " Wall");
        }
        for (BlockSetHelper.woodBlockSet set : BlockSetHelper.getWoodBlockSets()) {
            String name = formatName(set.name());

            translationBuilder.add(set.base(), name + " Planks");
            translationBuilder.add(set.stairs(), name + " Stairs");
            translationBuilder.add(set.slab(), name + " Slab");
            translationBuilder.add(set.fence(), name + " Fence");
            translationBuilder.add(set.fenceGate(), name + " Fence Gate");
            translationBuilder.add(set.button(), name + " Button");
            translationBuilder.add(set.pressurePlate(), name + " Pressure Plate");
            translationBuilder.add(set.door(), name + " Door");
            translationBuilder.add(set.trapdoor(), name + " Trapdoor");

            translationBuilder.add("item." + set.modName() + "." + set.name() + "_planks", name + " Planks");
            translationBuilder.add("item." + set.modName() + "." + set.name() + "_stairs", name + " Stairs");
            translationBuilder.add("item." + set.modName() + "." + set.name() + "_slab", name + " Slab");
            translationBuilder.add("item." + set.modName() + "." + set.name() + "_fence", name + " Fence");
            translationBuilder.add("item." + set.modName() + "." + set.name() + "_fence_gate", name + " Fence Gate");
            translationBuilder.add("item." + set.modName() + "." + set.name() + "_button", name + " Button");
            translationBuilder.add("item." + set.modName() + "." + set.name() + "_pressure_plate", name + " Pressure Plate");
            translationBuilder.add("item." + set.modName() + "." + set.name() + "_door", name + " Door");
            translationBuilder.add("item." + set.modName() + "." + set.name() + "_trapdoor", name + " Trapdoor");
        }
    }

    private static String formatName(String name) {
        String[] words = name.split("_");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (word.isEmpty()) {
                continue;
            }
            if (!result.isEmpty()) {
                result.append(" ");
            }
            result.append(Character.toUpperCase(word.charAt(0)));

            if (word.length() > 1) {
                result.append(word.substring(1));
            }
        }

        return result.toString();
    }
}
