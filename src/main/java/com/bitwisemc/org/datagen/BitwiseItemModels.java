package com.bitwisemc.org.datagen;

import com.bitwisemc.org.BitwiseMC;
import com.bitwisemc.org.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BitwiseItemModels extends ItemModelProvider {

    public BitwiseItemModels(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, BitwiseMC.MODID, helper);
    }

    private void registerGateModel(String name) {
        withExistingParent(name, mcLoc("item/generated"))
                .texture("layer0", modLoc("item/" + name));
    }

    @Override
    protected void registerModels() {
        registerGateModel("and_gate");
        registerGateModel("not_gate");
        registerGateModel("xor_gate");
    }
}
