package com.bitwisemc.org.datagen;

import com.bitwisemc.org.BitwiseMC;
import com.bitwisemc.org.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BitwiseBlockTags extends BlockTagsProvider {
    public BitwiseBlockTags(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, BitwiseMC.MODID, helper);
    }

    /**
     * Add tags to items about mineability and level required etc
     */
    @Override
    protected void addTags() {
        tag(BlockTags.MINEABLE_WITH_AXE)
                .add(Registration.MYSTERIOUS_ORE_OVERWORLD.get());
    }
}
