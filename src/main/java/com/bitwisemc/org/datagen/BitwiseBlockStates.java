package com.bitwisemc.org.datagen;

import com.bitwisemc.org.BitwiseMC;
import com.bitwisemc.org.setup.Registration;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.*;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Map;

public class BitwiseBlockStates extends BlockStateProvider {
    public BitwiseBlockStates(DataGenerator gen, ExistingFileHelper helper) {
        super(gen, BitwiseMC.MODID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        createGateBlock(Registration.AND_GATE.get());
        createGateBlock(Registration.EXCLUSIVE_OR_GATE.get());
        createGateBlock(Registration.NOT_GATE.get());
    }

    private void addDiodeStates(Block block, ModelFile modelFile, boolean powered, Direction direction, int rotation) {
        getVariantBuilder(block).partialState()
                .with(BlockStateProperties.HORIZONTAL_FACING, direction)
                .with(BlockStateProperties.POWERED, powered)
                .modelForState()
                .rotationY(rotation)
                .modelFile(modelFile)
                .addModel();
    }

    private ModelFile makeDiodeModelFile(ResourceLocation texture, String location) {
        return models().getBuilder(location)
                .texture("top", texture)
                .texture("slab", blockTexture(Blocks.SMOOTH_STONE))
                .element()
                .from(0,0,0)
                .to(16,2,16)
                .face(Direction.DOWN).uvs(0,0,16,16).texture("#slab").cullface(Direction.DOWN).end()
                .face(Direction.UP).uvs(0,0,16,16).texture("#top").end()
                .face(Direction.NORTH).uvs(0,0,16,16).texture("#slab").cullface(Direction.NORTH).end()
                .face(Direction.SOUTH).uvs(0,14,16,16).texture("#slab").cullface(Direction.SOUTH).end()
                .face(Direction.WEST).uvs(0,14,16,16).texture("#slab").cullface(Direction.WEST).end()
                .face(Direction.EAST).uvs(0,14,16,16).texture("#slab").cullface(Direction.EAST).end()
                .end();
    }

    private void createGateBlock(Block block) {
        ResourceLocation blockLocation = block.getRegistryName();
        String onString = blockLocation.toString() + "_on";
        ModelFile offModel = makeDiodeModelFile(blockTexture(block), blockLocation.toString());
        ModelFile onModel = makeDiodeModelFile(modLoc("block/" + block.getRegistryName().getPath() + "_on"), onString);
        Map<Direction, Integer> horizontals = Map.of(
                Direction.NORTH, 180,
                Direction.EAST, 270,
                Direction.SOUTH, 0,
                Direction.WEST, 90
        );
        for (Map.Entry<Direction, Integer> entry : horizontals.entrySet()) {
            addDiodeStates(block, onModel, true, entry.getKey(), entry.getValue());
            addDiodeStates(block, offModel, false, entry.getKey(), entry.getValue());
        }
    }
}
