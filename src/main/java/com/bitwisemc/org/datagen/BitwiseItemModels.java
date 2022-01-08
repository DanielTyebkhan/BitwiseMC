package com.bitwisemc.org.datagen;

import com.bitwisemc.org.BitwiseMC;
import com.bitwisemc.org.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BitwiseItemModels extends ItemModelProvider {

    public BitwiseItemModels(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, BitwiseMC.MODID, helper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(Registration.AND_GATE_ITEM.get().getRegistryName().getPath(), modLoc("block/and_gate"));
        withExistingParent(Registration.EXCLUSIVE_OR_GATE_ITEM.get().getRegistryName().getPath(), modLoc("block/and_gate"));
    }
}
