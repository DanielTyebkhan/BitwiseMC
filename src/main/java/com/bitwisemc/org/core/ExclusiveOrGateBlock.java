package com.bitwisemc.org.core;

public class ExclusiveOrGateBlock extends BinaryInputBlock {
    public ExclusiveOrGateBlock(Properties props) {
        super(props);
    }

    @Override
    protected boolean powerDecider(int leftInput, int rightInput) {
        return (leftInput > 0 && rightInput <= 0) || (rightInput > 0 && leftInput <= 0);
    }
}
