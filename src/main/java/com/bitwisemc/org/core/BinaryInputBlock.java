package com.bitwisemc.org.core;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DiodeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;

public abstract class BinaryInputBlock extends DiodeBlock {
    protected BinaryInputBlock(Properties props) {
        super(props);
        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(FACING, Direction.NORTH)
                        .setValue(POWERED, Boolean.valueOf(false))
        );
    }

    protected abstract boolean powerDecider(int leftInput, int rightInput);

    @Override
    protected  boolean shouldTurnOn(Level level, BlockPos pos, BlockState state) {
        Direction dir = state.getValue(FACING);
        Direction counterClockWise = dir.getCounterClockWise();
        Direction clockWise = dir.getClockWise();
        int rightPower = getAlternateSignalAt(level, pos.relative(counterClockWise), counterClockWise);
        int leftPower = getAlternateSignalAt(level, pos.relative(clockWise), clockWise);
        System.out.println("LeftPower: " + leftPower + ", RightPower: " + rightPower);
        return powerDecider(leftPower, rightPower);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(FACING, POWERED);
    }

    @Override
    protected int getDelay(BlockState pState) {
        return 2;
    }

    @Override
    protected int getInputSignal(Level pLevel, BlockPos pPos, BlockState pState) {
        return 0;
    }
}
