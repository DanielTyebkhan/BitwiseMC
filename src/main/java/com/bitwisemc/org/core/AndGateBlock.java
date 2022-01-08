package com.bitwisemc.org.core;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DiodeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

public class AndGateBlock extends DiodeBlock {
    public AndGateBlock(Properties props) {
        super(props);
        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(FACING, Direction.NORTH)
                        .setValue(POWERED, Boolean.valueOf(false))
        );
    }

    @Override
    protected boolean shouldTurnOn(Level pLevel, BlockPos pPos, BlockState pState) {
        Direction dir = pState.getValue(FACING);
        Direction counterClockWise = dir.getCounterClockWise();
        Direction clockWise = dir.getClockWise();
        int rightPower = getAlternateSignalAt(pLevel, pPos.relative(counterClockWise), counterClockWise);
        int leftPower = getAlternateSignalAt(pLevel, pPos.relative(clockWise), clockWise);
        System.out.println("LeftPower: " + leftPower + ", RightPower: " + rightPower);
        return leftPower > 0 && rightPower > 0;
    }

    @Override
    protected int getOutputSignal(BlockGetter pLevel, BlockPos pPos, BlockState pState) {
        return super.getOutputSignal(pLevel, pPos, pState);
    }

    @Override
    protected int getInputSignal(Level pLevel, BlockPos pPos, BlockState pState) {
        return 0;
    }

    @Override
    protected int getDelay(BlockState pState) {
        return 2;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, POWERED);
    }


}
