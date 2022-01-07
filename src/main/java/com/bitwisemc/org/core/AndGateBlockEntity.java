package com.bitwisemc.org.core;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

import static net.minecraft.world.level.block.piston.MovingPistonBlock.FACING;

public class AndGateBlockEntity extends BlockEntity {
    public AndGateBlockEntity(BlockEntityType<?> pType, BlockPos pWorldPosition, BlockState pBlockState) {
        super(pType, pWorldPosition, pBlockState);
    }

//    public static final BlockEntityType<AndGateBlockEntity> AND_GATE
//    public AndGateBlock(BlockPos pos, BlockState blockState) {
//        super(BlockEntityType.)
//    }
}
