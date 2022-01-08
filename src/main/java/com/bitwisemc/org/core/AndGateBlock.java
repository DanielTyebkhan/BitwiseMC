package com.bitwisemc.org.core;

public class AndGateBlock extends BinaryInputBlock {
    public AndGateBlock(Properties props) {
        super(props);
    }

    @Override
    protected boolean powerDecider(int leftInput, int rightInput) {
        return leftInput > 0 && rightInput > 0;
    }
}
