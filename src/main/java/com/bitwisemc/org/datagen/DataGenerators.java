package com.bitwisemc.org.datagen;

import com.bitwisemc.org.BitwiseMC;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = BitwiseMC.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        if (event.includeServer()) {
//            generator.addProvider(new BitwiseRecipes(generator));
//            generator.addProvider((new BitwiseTables(generator)));
            BitwiseBlockTags blockTags = new BitwiseBlockTags(generator, event.getExistingFileHelper());
            generator.addProvider(blockTags);
            generator.addProvider(new BitwiseItemTags(generator, blockTags, event.getExistingFileHelper()));
        }
        if (event.includeClient()) {
            generator.addProvider(new BitwiseBlockStates(generator, event.getExistingFileHelper()));
            generator.addProvider(new BitwiseItemModels(generator, event.getExistingFileHelper()));
            generator.addProvider(new BitwiseLanguageProvider(generator, "en_us"));
        }
    }
}
