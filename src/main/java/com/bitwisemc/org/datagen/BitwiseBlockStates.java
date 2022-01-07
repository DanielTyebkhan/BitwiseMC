package com.bitwisemc.org.datagen;

import com.bitwisemc.org.BitwiseMC;
import com.bitwisemc.org.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.loading.moddiscovery.ClasspathLocator;

public class BitwiseBlockStates extends BlockStateProvider {
    public BitwiseBlockStates(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, BitwiseMC.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(Registration.MYSTERIOUS_ORE_OVERWORLD.get());
        createAndGateBlock();
    }

    private void createAndGateBlock() {
        // TODO: add on variant
        Block andGate = Registration.AND_GATE.get();
        ModelFile off = models().cubeTop("and_gate", mcLoc("block/stone"), modLoc("block/and_gate"));
        simpleBlock(andGate, off);
    }
}
